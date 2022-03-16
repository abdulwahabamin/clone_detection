    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (mediaPlayer == null) {
                if (callback.songChangedFromNotification()) {
                    mediaPlayer = PlayBackUtil.getMediaPlayer();
                    callback.resetChangedSongFromNotification();
                } else {
                    if (PlayBackUtil.getCurrentSong() != null && rhythmSong.getSongLocation()
                            .equals(PlayBackUtil.getCurrentSong().getSongLocation())) {
                        mediaPlayer = PlayBackUtil.getMediaPlayer();
                        startTimer();

                    } else {
                        PlayBackUtil.setCurrentSong(rhythmSong);
                        mediaPlayer = PlayBackUtil.setMediaPlayer(getContext()
                                .getApplicationContext(), rhythmSong.getSongLocation());
                    }
                }
                removePlayerListeners();
                setPlayerListeners();
            }

            if (beenDrawn) {
                trackProgress.setProgress(0);
                updateDuration("0:00", milliSecondsToTimer(mediaPlayer.getDuration()));
            }
            callback.setToolBarText(rhythmSong.getArtistTitle(), rhythmSong.getAlbumTitle());
            callback.changePlayerStyle(vibrantColor, backgroundColor, songPosition);
            PlayBackUtil.setCurrentSong(rhythmSong);
        } else {
            if (mediaPlayer != null) {
                stopTimer();
                removePlayerListeners();
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
        }
    }

