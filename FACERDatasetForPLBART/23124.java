	public synchronized void addSong(Song song) {
		if (song != null) {
			clear();
			playQueue.add(song);
		}
	}

