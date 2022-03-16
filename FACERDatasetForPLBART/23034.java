		public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
			if (parent.equals(listView)) {
				// Add all songs and start playing the one in the index=position
				if (playQueue.addAllSongs(songsArrayAdap.getCollection(), position)) {
					// Start music service
					Intent intent = new Intent(AlbumSongsFragment.this.getActivity(), MusicService.class);
					intent.setAction(MusicService.ACTION_NEXT);
					mainActivity.startService(intent);
					mainActivity.addButtonsFragmentIfNotEmpty();
				} else {
					// The songs cannot be added to the play list, List too full
					// or array adapter empty.
					Toast.makeText(AlbumSongsFragment.this.getActivity(),
							getResources().getString(R.string.queue_full), Toast.LENGTH_LONG).show();
				}
			}
		}

