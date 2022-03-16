    private void getIntentAction(){
        if (getAction==MainActivity.forNextKey) {
            skipToNextTrack();
        }
        else if (getAction==MainActivity.forPreviousKey){
            skipToPreviousTrack(true);
        }
        else if (getAction==MainActivity.forSkipTrack){
            skipToTrack(PlayerConstants.SONG_NUMBER);
        }
        else if (getAction==MainActivity.forNothingKey) {
            mHandler.post(setLastposition);
        }
    }

