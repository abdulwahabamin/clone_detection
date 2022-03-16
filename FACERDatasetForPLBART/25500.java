		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MusicPlaybackService.MSG_SERVICE_STATUS:
				String currentSongName = msg.getData().getString(MusicPlaybackService.PRETTY_SONG_NAME);
				TextView tv = (TextView) _activity.findViewById(R.id.songName);
				if(!tv.getText().equals(currentSongName)){
					tv.setText(currentSongName);
				}

				String currentAlbumName = msg.getData().getString(MusicPlaybackService.PRETTY_ALBUM_NAME);
				tv = (TextView) _activity.findViewById(R.id.albumName);
				if(!tv.getText().equals(currentAlbumName)){
					tv.setText(currentAlbumName);
				}

				String currentArtistName = msg.getData().getString(MusicPlaybackService.PRETTY_ARTIST_NAME);
				tv = (TextView) _activity.findViewById(R.id.artistName);
				if(!tv.getText().equals(currentArtistName)){
					tv.setText(currentArtistName);
				}

				boolean isShuffling = msg.getData().getBoolean(MusicPlaybackService.IS_SHUFFLING);
				ImageButton shuffle = (ImageButton)_activity.findViewById(R.id.shuffle);
				if(shuffle.isSelected() != isShuffling){
					shuffle.setSelected(isShuffling);
				}

				PlaybackState state = PlaybackState.values()[msg.getData().getInt(MusicPlaybackService.PLAYBACK_STATE, 0)];
				ImageButton playPause = (ImageButton)_activity.findViewById(R.id.playPause);
				if(playPause.getContentDescription().equals(_activity.getResources().getString(R.string.play))){
					if(state == PlaybackState.PLAYING){
						playPause.setImageDrawable(_activity.getResources().getDrawable(R.drawable.ic_action_pause));
						playPause.setContentDescription(_activity.getResources().getString(R.string.pause));
					}
				} else {
					if(state == PlaybackState.PAUSED){
						playPause.setImageDrawable(_activity.getResources().getDrawable(R.drawable.ic_action_play));
						playPause.setContentDescription(_activity.getResources().getString(R.string.play));
					}
				}
				int duration = msg.getData().getInt(MusicPlaybackService.TRACK_DURATION, -1);
				int position = msg.getData().getInt(MusicPlaybackService.TRACK_POSITION, -1);
				if(duration > 0){
					if(!_activity.userDraggingProgress){
						SeekBar seekBar = (SeekBar)_activity.findViewById(R.id.songProgressBar);
						seekBar.setMax(duration);
						seekBar.setProgress(position);
						_activity.updateSongProgressLabel(position);
					}
				}
				break;
			default:
				super.handleMessage(msg);
			}
		}

