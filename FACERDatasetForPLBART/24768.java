        @Override
        public void onProgressChanged(SeekBar seekBar, int seekBarPosition, boolean changedByUser) {

            try {
                long currentSongDuration = PlayerConstants.mSongPlayback.getCurrentMediaPlayer().getDuration();
                seekBar.setMax((int) currentSongDuration / 1000);
                if (changedByUser)
                    mPresentTime.setText(UtilFunctions.getDuration(seekBar.getProgress() * 1000));
            } catch (Exception e) {
            }
        }

