        @Override
        public void onCompletion(MediaPlayer mp) {

            //PlayerConstants.SONG_NUMBER=determineNextSongIndex();

            mHandler.removeCallbacks(startCrossFadeRunnable);
            mHandler.removeCallbacks(crossFadeRunnable);

            if (mHandler != null) {
                mHandler.post(startCrossFadeRunnable);
            }

            mFadeInVolume = 0.0f;
            mFadeOutVolume = 1.0f;

            getMediaPlayer().setVolume(1.0f, 1.0f);
            getMediaPlayer2().setVolume(1.0f, 1.0f);

            try {
                if (isAtEndOfQueue()) {
                    MainActivity.setSongPlay(PlayerConstants.SONG_NUMBER,0);
                    IflastSong();
                } else if (isMediaPlayer2Prepared()) {
                    MainActivity.setSongPlay(PlayerConstants.SONG_NUMBER,PlayerConstants.SONG_NUMBER+1);
                    PlayerConstants.SONG_NUMBER++;
                    startMediaPlayer2();
                } else {
                    MainActivity.setSongPlay(PlayerConstants.SONG_NUMBER,PlayerConstants.SONG_NUMBER+1);
                    PlayerConstants.SONG_NUMBER++;
                    mHandler.post(startMediaPlayer2IfPrepared);
                }

                MainActivity.changeUI();
                UpdateMetadata();
                MainActivity.updateImage();

            } catch (IllegalStateException e) {
                mHandler.post(startMediaPlayer2IfPrepared);
            }

        }

