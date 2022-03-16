	private void loadSongsOfAlbum() {
		if (!playQueue.isEmpty()) {
			songsArrayAdap.clear();
			Iterator<Song> ite = playQueue.getCollection().iterator();
			while (ite.hasNext())
				songsArrayAdap.add(ite.next());
			songsArrayAdap.notifyDataSetChanged();
		}
	}

