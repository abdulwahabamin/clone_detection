        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            int seekBarPosition = seekBar.getProgress();
            PlayerConstants.mSongPlayback.getCurrentMediaPlayer().seekTo(seekBarPosition * 1000);
            //Reinitiate the handler.
            mHandler.post(seekbarUpdateRunnable);
        }

