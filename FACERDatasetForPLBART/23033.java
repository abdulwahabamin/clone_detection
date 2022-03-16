	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		switch (item.getItemId()) {
		case R.id.cm_item_addSongQueue:
			// Add the song to the end of the queue
			Song song = songsArrayAdap.getItem(info.position);
			if (!playQueue.addSongQueue(song)) {
				// The songs cannot be added to the play list, List too full
				// or song null;
				Toast.makeText(AlbumSongsFragment.this.getActivity(), getResources().getString(R.string.queue_full),
						Toast.LENGTH_LONG).show();
			}
			// Add buttons fragment to main activity if the play queue is not
			// empty
			mainActivity.addButtonsFragmentIfNotEmpty();
			return true;
		case R.id.cm_item_addAlbumQueue:
			// Add all songs of the album to the end of the queue
			if (!playQueue.addAllSongsQueue(songsArrayAdap.getCollection())) {
				// The songs cannot be added to the play list, List too full
				// or collection adapter empty.
				Toast.makeText(AlbumSongsFragment.this.getActivity(), getResources().getString(R.string.queue_full),
						Toast.LENGTH_LONG).show();
			}
			// Add buttons fragment to main activity if the play queue is not
			// empty
			mainActivity.addButtonsFragmentIfNotEmpty();
			return true;
		default:
			return super.onContextItemSelected(item);
		}
	}

