		@Override
		public void handleMessage(Message msg) {
			Log.i(TAG, "Music Playback service got a message!");
			switch (msg.what) {
			case MSG_REGISTER_CLIENT:
				Log.i(TAG, "Got MSG_REGISTER_CLIENT");
				synchronized (_service.mClients) {
					_service.mClients.add(msg.replyTo);
				}
				break;
			case MSG_UNREGISTER_CLIENT:
				Log.i(TAG, "Got MSG_UNREGISTER_CLIENT");
				synchronized (_service.mClients) {
					_service.mClients.remove(msg.replyTo);
				}
				break;
			case MSG_PLAYPAUSE:
				// if we got a playpause message, assume that the user can hear
				// what's happening and wants to switch it.
				Log.i(TAG, "Got a playpause message!");
				// Assume that we're not changing songs
				_service.playPause();
				break;
			case MSG_NEXT:
				Log.i(TAG, "Got a next message!");
				_service.next();
				break;
			case MSG_PREVIOUS:
				Log.i(TAG, "Got a previous message!");
				_service.previous();
				break;
			case MSG_JUMPBACK:
				Log.i(TAG, "Got a jump back message!");
				_service.jumpback();
				break;
			case MSG_TOGGLE_SHUFFLE:
				Log.i(TAG, "Got a toggle shuffle message!");
				_service.toggleShuffle();
				break;
			case MSG_SET_PLAYLIST:
				Log.i(TAG, "Got a set playlist message!");
				_service.songAbsoluteFileNames = msg.getData().getStringArray(
						SongList.SONG_ABS_FILE_NAME_LIST);
				_service.songAbsoluteFileNamesPosition = msg.getData().getInt(
						SongList.SONG_ABS_FILE_NAME_LIST_POSITION);
				_service.songFile = new File(
						_service.songAbsoluteFileNames[_service.songAbsoluteFileNamesPosition]);
				_service.artist = msg.getData().getString(ArtistList.ARTIST_NAME);
				_service.artistAbsPath = msg.getData().getString(ArtistList.ARTIST_ABS_PATH_NAME);
				_service.album = msg.getData().getString(AlbumList.ALBUM_NAME);
				int songPosition = msg.getData().getInt(TRACK_POSITION, 0);
				_service.startPlayingFile(songPosition);
				_service.updateNotification();
				_service.resetShuffle();
				break;
			case MSG_REQUEST_STATE:
				Log.i(TAG, "Got a state request message!");
				break;
			case MSG_SEEK_TO:
				Log.i(TAG, "Got a seek request message!");
				int progress = msg.getData().getInt(TRACK_POSITION);
				_service.jumpTo(progress);
				break;
			default:
				super.handleMessage(msg);
			}
		}

