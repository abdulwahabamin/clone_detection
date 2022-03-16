    public boolean prepareSong(final Song song) throws IOException {
        if(mediaPlayer!=null) {
            mediaPlayer.release();
        }
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        if(song.getFilePath().equals(Library.REMOTE_SONG_MISSING_PATH)) {
            final boolean[] fetched = {false};

            ShareGroup.getSong(song.getLibraryUsername(), song.get_id(),
                    new ShareGroup.GetSongListener() {
                @Override
                public void onGotSong(String songFilePath) {
                    try {
                        fetched[0] = true;
                        mediaPlayer.setDataSource(context, Uri.parse(songFilePath));
                        mediaPlayer.prepare();
                        prepared = true;
                        countDownLatch.countDown();
                    } catch (IOException e) {
                        prepared = false;
                        countDownLatch.countDown();
                    }
                }

                @Override
                public void onFailedGettingSong() {
                    countDownLatch.countDown();
                }
            });

            try {
                countDownLatch.await();
                if(fetched[0] && prepared) {
                    return true;
                } else {
                    return false;
                }
            } catch (InterruptedException e) {
                return false;
            }
        } else {
            mediaPlayer.setDataSource(context, Uri.parse(song.getFilePath()));
            mediaPlayer.prepare();
            prepared = true;
            return true;
        }
    }

