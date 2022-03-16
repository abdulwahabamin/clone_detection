	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	    case R.id.select_all_music_library_editor:
	        /* DB IDs are sequential, so to save CPU cycles, 
	         * we'll just get the size of the DB (the number of 
	         * rows) and add that many entries to the HashSet.
	         */
	    	int songCount = mApp.getDBAccessHelper().getAllSongs().getCount();
	    	for (int i=0; i < songCount+1; i++) {
	    		songDBIdsList.add("" + i);
	    	}
	    	
	    	//Refresh the current fragment's listview.
	    	if (ArtistsPickerFragment.listView!=null) {
	    		ArtistsPickerFragment.listView.setAdapter(null);
	    		ArtistsPickerFragment.listView.setAdapter(new PlaylistEditorArtistsMultiselectAdapter(this, 
	    																								  ArtistsPickerFragment.cursor));
	    		ArtistsPickerFragment.listView.invalidate();
	    	}
	    	
	    	if (AlbumsPickerFragment.listView!=null) {
	    		AlbumsPickerFragment.listView.setAdapter(null);
	    		AlbumsPickerFragment.listView.setAdapter(new PlaylistEditorAlbumsMultiselectAdapter(this, 
	    																								  AlbumsPickerFragment.cursor));
	    		AlbumsPickerFragment.listView.invalidate();
	    	}
	    	
	    	if (SongsPickerFragment.listView!=null) {
	    		SongsPickerFragment.listView.setAdapter(null);
	    		SongsPickerFragment.listView.setAdapter(new PlaylistEditorSongsMultiselectAdapter(this, 
	    																								  SongsPickerFragment.cursor));
	    		SongsPickerFragment.listView.invalidate();
	    	}
	    	
	        return true;
	    case R.id.done_music_library_editor:
	    	createPlaylist();
	    	return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }

	}

