	private void updateSongProgressLabel(int progress){
		TextView progressLabel = (TextView)findViewById(R.id.songProgressLabel);
		int minutes = progress / (1000 * 60);
		int seconds = (progress % (1000 * 60)) / 1000;
		String time = String.format(Locale.getDefault(), "%d:%02d", minutes, seconds);
		progressLabel.setText(time);
	}

