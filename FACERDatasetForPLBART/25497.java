		public void onServiceConnected(ComponentName className, IBinder service) {
			mService = new Messenger(service);

			// Register with the service
			try {
				Message msg = Message.obtain(null,
						MusicPlaybackService.MSG_REGISTER_CLIENT);
				msg.replyTo = mMessenger;
				mService.send(msg);
			} catch (RemoteException e) {
				// In this case the service has crashed before we could even do
				// anything with it
			}

			if(this._nowPlaying.startPlayingRequired){
				if(desiredSongAbsFileNames != null){
					// set the playlist
					Message msg = Message.obtain(null, MusicPlaybackService.MSG_SET_PLAYLIST);
					msg.getData().putStringArray(SongList.SONG_ABS_FILE_NAME_LIST, desiredSongAbsFileNames);
					msg.getData().putInt(SongList.SONG_ABS_FILE_NAME_LIST_POSITION, desiredAbsSongFileNamesPosition);
					msg.getData().putString(ArtistList.ARTIST_NAME, desiredArtistName);
					msg.getData().putString(ArtistList.ARTIST_ABS_PATH_NAME, desiredArtistAbsPath);
					msg.getData().putString(AlbumList.ALBUM_NAME, desiredAlbumName);
					msg.getData().putInt(MusicPlaybackService.TRACK_POSITION, desiredSongProgress);
					try {
						Log.i(TAG, "Sending a playlist!");
						mService.send(msg);
					} catch (RemoteException e) {
						e.printStackTrace();
					}

					// start playing!
					msg = Message.obtain(null, MusicPlaybackService.MSG_PLAYPAUSE);
					try {
						Log.i(TAG, "Sending a play command!");
						mService.send(msg);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}

		}

