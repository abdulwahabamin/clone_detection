	/**
	 * Moves the cursor to the specified index in the queue.
	 * Returns true if the index was valid and the cursor 
	 * position was moved successfully. False, otherwise.
	 */
	public boolean moveCursorToIndex(int index) {
		if (index < getCursor().getCount() && index > -1) {
			getCursor().moveToPosition(getPlaybackIndecesList().get(index));
			return true;
		} else {
			return false;
		}
		
	}

