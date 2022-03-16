        @Override
        public void run() {
            try {
                if (PlayerConstants.SONG_NUMBER>-1) {
                    if (PlayerConstants.mSongPlayback.mCurrentMediaPlayer == 1)
                        if (PlayerConstants.mSongPlayback.isMediaPlayerPrepared())
                            setSeekbarDuration((int) PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER).getDuration());
                        else
                            mHandler.postDelayed(updateProgressBar, 200);

                    else if (PlayerConstants.mSongPlayback.isMediaPlayer2Prepared())
                        setSeekbarDuration((int) PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER).getDuration());
                    else
                        mHandler.postDelayed(updateProgressBar, 200);
                }
            }
            catch (Exception e){}
        }

