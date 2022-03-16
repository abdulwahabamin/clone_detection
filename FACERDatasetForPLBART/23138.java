	public Song getSongById(int songId) {
		for (int i = 0; i < playQueue.size(); i++) {
			Song song = playQueue.get(i);
			if (song.getId() == songId) {
				return song;
			}
		}
		return null;
	}

