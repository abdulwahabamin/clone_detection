    public void setLastposition(){
        if (PlayerConstants.SONG_NUMBER > -1) {
            if (prepareMediaPlayer(PlayerConstants.SONG_NUMBER))
            {
                mHandler.postDelayed(setSeekto, 300);
            }
            else
            {
                mHandler.post(checkTotalSong);
            }
        }
    }

