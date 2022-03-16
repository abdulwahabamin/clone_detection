	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		playButton = (ImageButton) getView().findViewById(R.id.button_play);
		playButton.setOnClickListener(clickListener);
		updatePlayButton();
		previousButton = (ImageButton) getView().findViewById(R.id.button_previous);
		previousButton.setOnClickListener(clickListener);
		nextButton = (ImageButton) getView().findViewById(R.id.button_next);
		nextButton.setOnClickListener(clickListener);
		textViewCurrentSong = (TextView) getView().findViewById(R.id.textView_current_song);
		textViewCurrentSong.setOnClickListener(clickListener);
		// Update the current song textView
		Song song = playQueue.getCurrent();
		if (song != null) {
			textViewCurrentSong.setText(song.getTitle() + " - " + song.getAlbum().getArtist());
		}
		super.onActivityCreated(savedInstanceState);
	}

