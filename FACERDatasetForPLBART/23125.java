	public synchronized boolean addSongQueue(Song song) {
		if (playQueue.size() <= MAX_SONGS_QUEUE) {
			if (song != null) {
				playQueue.add(song);
			}
			return true;
		}
		return false;
	}

