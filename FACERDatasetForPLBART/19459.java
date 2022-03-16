	/**
	 * Initializes the list of pointers to each cursor row.
	 */
	private void initPlaybackIndecesList(boolean playAll) {
		if (getCursor()!=null && getPlaybackIndecesList()!=null) {
			getPlaybackIndecesList().clear();
			for (int i=0; i < getCursor().getCount(); i++) {
				getPlaybackIndecesList().add(i);
			}
			
			if (isShuffleOn() && !playAll) {
                //Build a new list that doesn't include the current song index.
                ArrayList<Integer> newList = new ArrayList<Integer>(getPlaybackIndecesList());
                newList.remove(getCurrentSongIndex());

               //Shuffle the new list.
               Collections.shuffle(newList, new Random(System.nanoTime()));

                //Plug in the current song index back into the new list.
                newList.add(getCurrentSongIndex(), getCurrentSongIndex());
                mPlaybackIndecesList = newList;

			} else if (isShuffleOn() && playAll) {
                //Shuffle all elements.
                Collections.shuffle(getPlaybackIndecesList(), new Random(System.nanoTime()));
            }
			
		} else {
			stopSelf();
		}
		
	}

