		@Override
		public void onProgressChanged(SeekBar seekBar, int seekBarPosition, boolean changedByUser) {

            try {
                long currentSongDuration = mApp.getService().getCurrentMediaPlayer().getDuration();
                seekBar.setMax((int) currentSongDuration / 1000);

                if (changedByUser)
                    mSeekbarIndicatorText.setText(mApp.convertMillisToMinsSecs(seekBar.getProgress()*1000));
            } catch (Exception e) {
                e.printStackTrace();
            }

		}

