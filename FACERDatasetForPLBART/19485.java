	/**
	 * Grabs the song parameters at the specified index, retrieves its 
	 * data source, and beings to asynchronously prepare mMediaPlayer. 
	 * Once mMediaPlayer is prepared, mediaPlayerPrepared is called.
	 * 
	 * @return True if the method completed with no exceptions. False, otherwise.
	 */
	public boolean prepareMediaPlayer(int songIndex) {
		
		try {

            //Stop here if we're at the end of the queue.
            if (songIndex==-1)
                return true;

			//Reset mMediaPlayer to it's uninitialized state.
	    	getMediaPlayer().reset();
	    	
    		//Loop the player if the repeat mode is set to repeat the current song.
    		if (getRepeatMode()==Common.REPEAT_SONG) {
    			getMediaPlayer().setLooping(true);
    		}

	    	//Set mMediaPlayer's song data.
	    	SongHelper songHelper = new SongHelper();
	    	if (mFirstRun) {
	    		/*
	    		 * We're not preloading the next song (mMediaPlayer2 is not 
	    		 * playing right now). mMediaPlayer's song is pointed at 
	    		 * by mCurrentSongIndex.
	    		 */
	    		songHelper.populateSongData(mContext, songIndex);
                setMediaPlayerSongHelper(songHelper);
	    		//Set this service as a foreground service.
	    		startForeground(mNotificationId, buildNotification(songHelper));
	    	} else {
	    		songHelper.populateSongData(mContext, songIndex);
                setMediaPlayerSongHelper(songHelper);
	    	}

    		/*
    		 * Set the data source for mMediaPlayer and start preparing it 
    		 * asynchronously.
    		 */
	    	getMediaPlayer().setDataSource(mContext, getSongDataSource(getMediaPlayerSongHelper()));
			getMediaPlayer().setOnPreparedListener(mediaPlayerPrepared);
            getMediaPlayer().setOnErrorListener(onErrorListener);
            getMediaPlayer().prepareAsync();

        } catch (Exception e) {
            Log.e("DEBUG", "MESSAGE", e);
            e.printStackTrace();

            //Display an error toast to the user.
            showErrorToast();

            //Add the current song index to the list of failed indeces.
            getFailedIndecesList().add(songIndex);

            //Start preparing the next song.
            if (!isAtEndOfQueue() || mFirstRun)
                prepareMediaPlayer(songIndex+1);
            else
                return false;

            return false;
        }

		return true;
	}

