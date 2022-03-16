		public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
			if (parent.equals(listView)) {
				// Move to the song at index=position-1
				// -1 because we will tell the music service to play the next
				// song.
				if (playQueue.moveToSongAt(position - 1)) {
					// Start music service
					Intent intent = new Intent(PlayQueueFragment.this.getActivity(), MusicService.class);
					intent.setAction(MusicService.ACTION_NEXT);
					PlayQueueFragment.this.getActivity().startService(intent);
				} else {
					Log.e(PlayQueueFragment.this.getClass().getName(), "Error moving to song in the play queue, index="
							+ position);
				}
			}
		}

