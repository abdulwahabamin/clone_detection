    private void startTimer() {
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopTimer();
                trackProgress.setProgress(0);
                updateDuration("0:00", milliSecondsToTimer(mediaPlayer.getDuration()));
                playButton.setImageResource(R.drawable.ic_play_arrow_white_24dp);
                mediaPlayer.pause();

                switch (PlayBackUtil.getCurrentPlayMode()) {
                    case SHUFFLE_REPEAT:
                    case ALL_REPEAT:
                        playNext();
                        break;
                    case NONE:
                        if (songPosition != PlayBackUtil.getCurrentSongPosition()) {
                            playNext();
                        }
                        break;
                    case SINGLE_REPEAT:
                        startTimer();
                        mediaPlayer.start();
                        break;
                }
            }
        });
        handler.postDelayed(mRunnable, 500);
    }

