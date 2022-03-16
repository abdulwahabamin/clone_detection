        @Override
        public void run() {
            try {

                if (PlayerConstants.SONGS_LIST.size() > (PlayerConstants.SONG_NUMBER + 1)) {

                    //Set the next mMediaPlayer's volume and raise it incrementally.
                    if (getCurrentMediaPlayer() == getMediaPlayer()) {

                        getMediaPlayer2().setVolume(mFadeInVolume, mFadeInVolume);
                        getMediaPlayer().setVolume(mFadeOutVolume, mFadeOutVolume);

                        //If the mMediaPlayer is already playing or it hasn't been prepared yet, we can't use crossfade.
                        if (!getMediaPlayer2().isPlaying()) {

                            if (mMediaPlayer2Prepared == true) {

                                if (checkAndRequestAudioFocus() == true) {
                                    getMediaPlayer2().start();
                                } else {
                                    return;
                                }

                            }

                        }

                    } else {

                        getMediaPlayer().setVolume(mFadeInVolume, mFadeInVolume);
                        getMediaPlayer2().setVolume(mFadeOutVolume, mFadeOutVolume);

                        //If the mMediaPlayer is already playing or it hasn't been prepared yet, we can't use crossfade.
                        if (!getMediaPlayer().isPlaying()) {

                            if (mMediaPlayerPrepared == true) {

                                if (checkAndRequestAudioFocus() == true) {
                                    getMediaPlayer().start();
                                } else {
                                    return;
                                }

                            }

                        }

                    }

                    mFadeInVolume = mFadeInVolume + (float) (1.0f / (((float) mCrossfadeDuration) * 10.0f));
                    mFadeOutVolume = mFadeOutVolume - (float) (1.0f / (((float) mCrossfadeDuration) * 10.0f));

                    mHandler.postDelayed(crossFadeRunnable, 100);
                }

            } catch (Exception e) {

            }
        }

