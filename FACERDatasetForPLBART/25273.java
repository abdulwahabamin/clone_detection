        @Override
        public void run() {
            if (mediaPlayer != null && beenDrawn) {
                if (!mediaPlayer.isPlaying() || !trackProgress.isPressed()) {
                    final int currentProgress = (int) (((float) mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration()) * 100);
                    if (getActivity() != null) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                trackProgress.setProgress(currentProgress);
                                if (mediaPlayer != null) {
                                    playButton.setImageResource(mediaPlayer.isPlaying()
                                            ? R.drawable.ic_pause_white_24dp : R.drawable.ic_play_arrow_white_24dp);
                                    updateDuration(milliSecondsToTimer(mediaPlayer.getCurrentPosition()),
                                            milliSecondsToTimer(mediaPlayer.getDuration()));
                                }
                            }
                        });
                    }
                }
            }
            handler.postDelayed(mRunnable, 500);
        }

