	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	    case R.id.select_all_music_library_editor:
	        /* DB IDs are sequential, so to save CPU cycles, 
	         * we'll just get the size of the DB (the number of 
	         * rows) and add that many entries to the HashSet.
	         */
	    	Cursor cursor = null;
	    	if (dbHelper!=null) {
	    		cursor = dbHelper.getAllSongs();
	    	}
	    	
	    	int songCount = 0;
	    	if (cursor!=null) {
	    		songCount = cursor.getCount();
	    	} else {
	    		Toast.makeText(mContext, R.string.no_songs_to_select, Toast.LENGTH_SHORT).show();
	    		return true;
	    	}
	    	
	    	for (int i=0; i < songCount+1; i++) {
	    		songDBIdsList.add("" + i);
	    	}
	    	
	    	//Refresh the current fragment's listview.
	    	if (ArtistsPickerFragment.listView!=null) {
	    		ArtistsPickerFragment.listView.setAdapter(null);
	    		ArtistsPickerFragment.listView.setAdapter(new MusicLibraryEditorArtistsMultiselectAdapter(this, 
	    																								  ArtistsPickerFragment.cursor));
	    		ArtistsPickerFragment.listView.invalidate();
	    	}
	    	
	    	if (AlbumsPickerFragment.listView!=null) {
	    		AlbumsPickerFragment.listView.setAdapter(null);
	    		AlbumsPickerFragment.listView.setAdapter(new MusicLibraryEditorAlbumsMultiselectAdapter(this, 
	    																								  AlbumsPickerFragment.cursor));
	    		AlbumsPickerFragment.listView.invalidate();
	    	}
	    	
	    	if (SongsPickerFragment.listView!=null) {
	    		SongsPickerFragment.listView.setAdapter(null);
	    		SongsPickerFragment.listView.setAdapter(new MusicLibraryEditorSongsMultiselectAdapter(this, 
	    																								  SongsPickerFragment.cursor));
	    		SongsPickerFragment.listView.invalidate();
	    	}
	    	
	        return true;
	    case R.id.done_music_library_editor:
	    	createMusicLibrary();
	    	return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }

	}

