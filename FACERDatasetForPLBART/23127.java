	public synchronized boolean addAllSongs(Collection<Song> songs, int startingPosition) {
		if (!songs.isEmpty()) {
			if (songs.size() <= MAX_SONGS_QUEUE) {
				clear();
				playQueue.addAll(songs);
				if (startingPosition < playQueue.size() && startingPosition >= 0)
					// Minus 1 because it'll increment 1 before playing when
					// calling getNext()
					index = startingPosition - 1;
				return true;
			}
		}
		return false;
	}

