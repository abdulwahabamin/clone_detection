    void lastPosition(){
        int lastSong= UtilFunctions.getSharedPreferenceint(mContext,UtilFunctions.LastSongNumber,-1);
        if (lastSong>-1)
        {
            PlayerConstants.SONG_NUMBER=lastSong;
            PlayerConstants.lastDuration=UtilFunctions.getSharedPreferenceint(mContext,UtilFunctions.LastDuration,0);
        }
    }

