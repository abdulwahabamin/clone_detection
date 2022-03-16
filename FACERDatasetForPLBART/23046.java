	private void updatePlayButton() {
		if (playQueue.isPlaying()) {
			playButton.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_media_pause));
		} else {
			playButton.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_media_play));
		}
	}

