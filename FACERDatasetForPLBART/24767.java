        public void run() {
            try {
                long currentPosition = PlayerConstants.mSongPlayback.getCurrentMediaPlayer().getCurrentPosition();
                //smoothScrollSeekbar(currentPosition);
                mPresentTime.setText(UtilFunctions.getDuration(currentPosition));
                mMPSeekBar.setProgress((int) (currentPosition / 1000));
                mMiniProgressBar.setProgress(PlayerConstants.mSongPlayback.getCurrentMediaPlayer().getCurrentPosition());
                mHandler.postDelayed(seekbarUpdateRunnable, 100);
            } catch (Exception e) {
            }
        }

