	/**
	 * Moves the cursor back to the first song in the queue. 
	 * This does not necessarily move the cursor to index 0. 
	 * It moves it to the element at index 0 in 
	 * mPlaybackIndecesList.
	 */
	public void moveCursorToQueueStart() {
		getCursor().moveToPosition(getPlaybackIndecesList().get(0));
	}

