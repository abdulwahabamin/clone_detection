	public synchronized boolean addAllSongsQueue(Collection<Song> songs) {
		if (!songs.isEmpty()) {
			if (playQueue.size() + songs.size() <= MAX_SONGS_QUEUE) {
				playQueue.addAll(songs);
				return true;
			}
		}
		return false;
	}

