	private void sendUpdateToClients() {
		List<Messenger> toRemove = new ArrayList<Messenger>();
		synchronized (mClients) {
			for (Messenger client : mClients) {
				Message msg = Message.obtain(null, MSG_SERVICE_STATUS);
				Bundle b = new Bundle();
				if (songFile != null) {
					b.putString(PRETTY_SONG_NAME,
							Utils.getPrettySongName(songFile));
					b.putString(PRETTY_ALBUM_NAME, songFile.getParentFile()
							.getName());
					b.putString(PRETTY_ARTIST_NAME, songFile.getParentFile()
							.getParentFile().getName());
				} else {
					// songFile can be null while we're shutting down.
					b.putString(PRETTY_SONG_NAME, " ");
					b.putString(PRETTY_ALBUM_NAME, " ");
					b.putString(PRETTY_ARTIST_NAME, " ");
				}

				b.putBoolean(IS_SHUFFLING, this._shuffle);

				if (mp.isPlaying()) {
					b.putInt(PLAYBACK_STATE, PlaybackState.PLAYING.ordinal());
				} else {
					b.putInt(PLAYBACK_STATE, PlaybackState.PAUSED.ordinal());
				}
				// We might not be able to send the position right away if mp is
				// still being created
				// so instead let's send the last position we knew about.
				if (mp.isPlaying()) {
					lastDuration = mp.getDuration();
					lastPosition = mp.getCurrentPosition();
				}
				b.putInt(TRACK_DURATION, lastDuration);
				b.putInt(TRACK_POSITION, lastPosition);
				msg.setData(b);
				try {
					client.send(msg);
				} catch (RemoteException e) {
					e.printStackTrace();
					toRemove.add(client);
				}
			}

			for (Messenger remove : toRemove) {
				mClients.remove(remove);
			}
		}
	}

