	/**
	 * Moves the cursor forward to the last song in the queue. 
	 * This does not necessarily move the cursor to index 
	 * {cursorSize-1}. It moves it to the element at index 
	 * {cursorSize-1} in mPlaybackIndecesList.
	 */
	public void moveCursorToQueueEnd() {
		getCursor().moveToPosition(getPlaybackIndecesList().get(getPlaybackIndecesList().size()-1));
	}

