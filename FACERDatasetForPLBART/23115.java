	private void resetSongPlayingRef() {
		if (songPlaying != null) {
			// Set flag false and set reference to the current song to null
			Log.d("SongBlue", "Reseting song " + songPlaying.getTitle());
			songPlaying.setPlaying(false);
			songPlaying = null;
		}

	}

