        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            MediaControllerCompat.getMediaController(NowPlayingActivity.this).getTransportControls()
                    .seekTo(seekBar.getProgress());
            scheduleSeekbarUpdate();
        }

