    /**
     * Determines the next song's index based on the repeat 
     * mode and current song index. Returns -1 if we're at 
     * the end of the queue.
     */
    private int determineNextSongIndex() {
		if (isAtEndOfQueue() && getRepeatMode()==Common.REPEAT_PLAYLIST)
			return 0;
		else if (!isAtEndOfQueue() && getRepeatMode()==Common.REPEAT_SONG)
			return getCurrentSongIndex();
		else if (isAtEndOfQueue())
			return -1;
		else
			return (getCurrentSongIndex() + 1);
		
    }

