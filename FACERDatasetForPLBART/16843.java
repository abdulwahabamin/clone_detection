        @Override
        public void onStopTrackingTouch(CircularSeekBar seekBar) {
            MediaControllerCompat.getMediaController(NowPlayingActivity.this).getTransportControls()
                    .seekTo(seekBar.getProgress());
            scheduleSeekbarUpdate();
        }

