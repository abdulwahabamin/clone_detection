	public synchronized boolean moveToSongAt(int index) {
		// Index can be -1, it means that there is not current song and the next
		// one will be the fist of the list
		if (index >= -1 && index < playQueue.size()) {
			this.index = index;
			return true;
		}
		return false;
	}

