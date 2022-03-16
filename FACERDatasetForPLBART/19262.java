	public void createMusicLibrary() {
		//We're done with the database helper, so go ahead and close it.
		dbHelper.close();
		dbHelper = null;
		
		//Launch the AsyncTask that will create the new music library.
		AsyncCreateMusicLibraryTask task = new AsyncCreateMusicLibraryTask(this, this, songDBIdsList, libraryName, libraryIconName);
		task.execute();
		
	}

