	@Override
	// Runs when a new song is about to play
	public void onSongChanged() {
		Song song = playQueue.getCurrent();
		textViewCurrentSong.setText(song.getTitle() + " - " + song.getAlbum().getArtist());

	}

