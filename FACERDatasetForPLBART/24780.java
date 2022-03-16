    public static void updateUI() {
        try{
            mHandler.post(updateProgressBar);
            ViewAnimator.animate(mMiniSongName,mSongName,mMiniArtistAlbum,mArtistAlbum,mTotalTime)
                    .alpha(0)
                    .duration(300)
                    .onStop(new AnimationListener.Stop() {
                        @Override
                        public void onStop() {
                            String songName = PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER).getTitle();
                            String artist = PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER).getArtist();
                            String album = PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER).getAlbum();
                            long TotalDuration = PlayerConstants.SONGS_LIST.get(PlayerConstants.SONG_NUMBER).getDuration();
                            mMiniSongName.setText(songName);
                            mSongName.setText(songName);
                            mMiniArtistAlbum.setText(artist + " | " + album);
                            mArtistAlbum.setText(artist + " | " + album);
                            mTotalTime.setText(UtilFunctions.getDuration(TotalDuration));
                        }
                    })
                    .start();

            ViewAnimator.animate(mMiniSongName, mSongName, mMiniArtistAlbum, mArtistAlbum, mTotalTime)
                    .alpha(1)
                    .duration(300)
                    .startDelay(300)
                    .start();
        }catch(Exception e){
        }
    }

