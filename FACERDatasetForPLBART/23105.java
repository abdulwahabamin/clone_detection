	private void sendMusicUpdateToActivity(boolean playerStateChanged, boolean song_changed) {
		if (song_changed) {
			Log.d("SongBlue", "Notified song chaged, current song " + songPlaying.getTitle());
		}
		Intent intentMusicUpdate = new Intent(MUSIC_UPDATE);
		intentMusicUpdate.putExtra(PLAYER_STATE_CHANGED, playerStateChanged);
		intentMusicUpdate.putExtra(SONG_CHANGED, song_changed);
		sendBroadcast(intentMusicUpdate);
	}

