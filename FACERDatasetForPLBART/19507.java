    /**
     * Skips to the previous track (if there is one) and starts 
     * playing it. Returns true if the operation succeeded. 
     * False, otherwise.
     */
    public boolean skipToPreviousTrack() {

        /*
         * If the current track is not within the first three seconds,
         * reset it. If it IS within the first three seconds, skip to the
         * previous track.
         */
        try {
            if (getCurrentMediaPlayer().getCurrentPosition() > 3000) {
                getCurrentMediaPlayer().seekTo(0);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    	try {
    		//Reset both MediaPlayer objects.
    		getMediaPlayer().reset();
    		getMediaPlayer2().reset();
            clearCrossfadeCallbacks();
    		
    		//Loop the players if the repeat mode is set to repeat the current song.
    		if (getRepeatMode()==Common.REPEAT_SONG) {
    			getMediaPlayer().setLooping(true);
    			getMediaPlayer2().setLooping(true);
    		}
    		
    		//Remove crossfade runnables and reset all volume levels.
			getHandler().removeCallbacks(crossFadeRunnable);
			getMediaPlayer().setVolume(1.0f, 1.0f);
			getMediaPlayer2().setVolume(1.0f, 1.0f);
    		
    		//Decrement the song index.
    		decrementCurrentSongIndex();
    		
    		//Update the UI.
    		String[] updateFlags = new String[] { Common.UPDATE_PAGER_POSTIION };
    		String[] flagValues = new String[] { getCurrentSongIndex() + "" };
    		mApp.broadcastUpdateUICommand(updateFlags, flagValues);
    		
    		//Start the playback process.
    		mFirstRun = true;
    		prepareMediaPlayer(getCurrentSongIndex());
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	
    	return true;
    }

