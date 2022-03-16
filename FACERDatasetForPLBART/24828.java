        @Override
        public void onCompletion(MediaPlayer mp) {
            //PlayerConstants.SONG_NUMBER=determineNextSongIndex();

            //Remove the crossfade playback.
            mHandler.removeCallbacks(startCrossFadeRunnable);
            mHandler.removeCallbacks(crossFadeRunnable);

            //Set the track position handler (notifies the handler when the track should start being faded).
            if (mHandler!=null) {
                mHandler.post(startCrossFadeRunnable);
            }

            //Reset the fadeVolume variables.
            mFadeInVolume = 0.0f;
            mFadeOutVolume = 1.0f;

            //Reset the volumes for both mediaPlayers.
            getMediaPlayer().setVolume(1.0f, 1.0f);
            getMediaPlayer2().setVolume(1.0f, 1.0f);



            try {
                if (isAtEndOfQueue()) {
                    MainActivity.setSongPlay(PlayerConstants.SONG_NUMBER,0);
                    IflastSong();
                } else if (isMediaPlayerPrepared()) {
                    MainActivity.setSongPlay(PlayerConstants.SONG_NUMBER,PlayerConstants.SONG_NUMBER+1);
                    PlayerConstants.SONG_NUMBER++;
                    startMediaPlayer();
                } else {
                    MainActivity.setSongPlay(PlayerConstants.SONG_NUMBER,PlayerConstants.SONG_NUMBER+1);
                    PlayerConstants.SONG_NUMBER++;
                    //Check every 100ms if mMediaPlayer is prepared.
                    mHandler.post(startMediaPlayerIfPrepared);
                }

                MainActivity.changeUI();
                UpdateMetadata();
                MainActivity.updateImage();

            } catch (IllegalStateException e) {
                //mMediaPlayer isn't prepared yet.
                mHandler.post(startMediaPlayerIfPrepared);
            }

        }

