	private boolean playSong(Song song) {
		resetSongPlayingRef();
		if (song != null) {
			if (isMediaPlayerInit) {
				mMediaPlayer.reset();
				try {
					mMediaPlayer.setDataSource(getApplicationContext(), getUriFromSong(song));
					// prepare async to not block main thread
					mMediaPlayer.prepareAsync();
					songPlaying = song;
					// Set the flag in the song to playing
					songPlaying.setPlaying(true);
					return true;
				} catch (IllegalArgumentException e) {
					Log.e(e.getClass().getName(), e.getMessage(), e);
				} catch (SecurityException e) {
					Log.e(e.getClass().getName(), e.getMessage(), e);
				} catch (IllegalStateException e) {
					Log.e(e.getClass().getName(), e.getMessage(), e);
				} catch (IOException e) {
					Log.e(e.getClass().getName(), e.getMessage(), e);
				}
			}
		} else {
			Log.e(getClass().getName(), "Error retrieving next song from queue, song is null");
		}
		return false;
	}

