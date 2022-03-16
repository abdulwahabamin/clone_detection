    /**
     * On Song Playing completed
     * if repeat is ON play same song again
     * if shuffle is ON play random song
     */
    @Override
    public void onCompletion(MediaPlayer arg0) {
        if (isBTEnabled()) {
            try {
                if (!(songsList == null)) {
                    if (songsList.size() > 0) {

                        if (isRepeat) {
                            playSong(currentSongIndex);
                        } else if (isShuffle) {
                            Random rand = new Random();
                            currentSongIndex = rand.nextInt((songsList.size() - 1) + 1);
                            playSong(currentSongIndex);
                        } else {
                            if (currentSongIndex < (songsList.size() - 1)) {
                                playSong(currentSongIndex + 1);
                                currentSongIndex = currentSongIndex + 1;
                            } else {
                                playSong(0);
                                currentSongIndex = 0;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                // Toast.makeText(getApplicationContext(), getString(R.string.exception) + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

