    /**
     * Toggles shuffle mode and returns whether shuffle is now on or off.
	 */
    public boolean toggleShuffleMode() {
    	if (isShuffleOn()) {
    		//Set shuffle off.
    		mApp.getSharedPreferences().edit().putBoolean(Common.SHUFFLE_ON, false).commit();

    		//Save the element at the current index.
    		int currentElement = getPlaybackIndecesList().get(getCurrentSongIndex());
    		
    		//Reset the cursor pointers list.
    		Collections.sort(getPlaybackIndecesList());
    		
    		//Reset the current index to the index of the old element.
    		setCurrentSongIndex(getPlaybackIndecesList().indexOf(currentElement));
    		
    		
    	} else {
    		//Set shuffle on.
    		mApp.getSharedPreferences().edit().putBoolean(Common.SHUFFLE_ON, true).commit();

            //Build a new list that doesn't include the current song index.
            ArrayList<Integer> newList = new ArrayList<Integer>(getPlaybackIndecesList());
            newList.remove(getCurrentSongIndex());

            //Shuffle the new list.
            Collections.shuffle(newList, new Random(System.nanoTime()));

            //Plug in the current song index back into the new list.
            newList.add(getCurrentSongIndex(), getCurrentSongIndex());
            mPlaybackIndecesList = newList;

            //Collections.shuffle(getPlaybackIndecesList().subList(0, getCurrentSongIndex()));
            //Collections.shuffle(getPlaybackIndecesList().subList(getCurrentSongIndex()+1, getPlaybackIndecesList().size()));
    		
    	}
    	
    	/* Since the queue changed, we're gonna have to update the 
    	 * next MediaPlayer object with the new song info.
    	 */
    	prepareAlternateMediaPlayer();
    	
    	//Update all UI elements with the new queue order.
    	mApp.broadcastUpdateUICommand(new String[] { Common.NEW_QUEUE_ORDER }, new String[] { "" });
    	return isShuffleOn();
    }

