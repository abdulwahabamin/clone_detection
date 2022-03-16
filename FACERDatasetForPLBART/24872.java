    public void saveLastPosition(){
        if (PlayerConstants.SONG_NUMBER>-1) {
            UtilFunctions.saveSharedPreferenceint(getApplicationContext(), UtilFunctions.LastDuration, getCurrentMediaPlayer().getCurrentPosition());
            UtilFunctions.saveSharedPreferenceint(getApplicationContext(), UtilFunctions.LastSongNumber, PlayerConstants.SONG_NUMBER);
        }
    }

