        @Override
        public void run() {
            if (isMediaPlayerPrepared()) {
                {
                    if (SongPlayback.isPlayFromMainFalse==isPlayOnStart)
                        pausePlayback();
                    else {
                        MainActivity.changeButton();
                        MainActivity.updateUI();
                    }
                }
                mHandler.removeCallbacks(this);
                getCurrentMediaPlayer().seekTo(PlayerConstants.lastDuration);
                PlayerConstants.lastDuration = 0;
            }
            else {
                mHandler.postDelayed(this, 300);
            }
        }

