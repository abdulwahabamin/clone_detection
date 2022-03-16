	/**
	 * Grabs the song parameters at the specified index, retrieves its 
	 * data source, and beings to asynchronously prepare mMediaPlayer2. 
	 * Once mMediaPlayer2 is prepared, mediaPlayer2Prepared is called.
	 * 
	 * @return True if the method completed with no exceptions. False, otherwise.
	 */
	public boolean prepareMediaPlayer2(int songIndex) {
		
		try {

            //Stop here if we're at the end of the queue.
            if (songIndex==-1)
                return true;
			
			//Reset mMediaPlayer2 to its uninitialized state.
	    	getMediaPlayer2().reset();
	    	
    		//Loop the player if the repeat mode is set to repeat the current song.
    		if (getRepeatMode()==Common.REPEAT_SONG) {
    			getMediaPlayer2().setLooping(true);
    		}
	    	
	    	//Set mMediaPlayer2's song data.
	    	SongHelper songHelper = new SongHelper();
	    	songHelper.populateSongData(mContext, songIndex);
	    	setMediaPlayer2SongHelper(songHelper);

    		/*
    		 * Set the data source for mMediaPlayer and start preparing it 
    		 * asynchronously.
    		 */
	    	getMediaPlayer2().setDataSource(mContext, getSongDataSource(getMediaPlayer2SongHelper()));
			getMediaPlayer2().setOnPreparedListener(mediaPlayer2Prepared);
			getMediaPlayer2().setOnErrorListener(onErrorListener);
			getMediaPlayer2().prepareAsync();

		} catch (Exception e) {
			e.printStackTrace();

            //Display an error toast to the user.
            showErrorToast();

			//Add the current song index to the list of failed indeces.
			getFailedIndecesList().add(songIndex);
			
			//Start preparing the next song.
			if (!isAtEndOfQueue())
				prepareMediaPlayer2(songIndex+1);
			else
				return false;
			
			return false;
		}
		
		return true;
	}

