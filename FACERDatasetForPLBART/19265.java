	@Override
	public void onPause() {
		super.onPause();
		songDBIdsList.clear();
		
		if (dbHelper!=null) {
			dbHelper.close();
			dbHelper = null;
		}
		
		if (isFinishing()) {
			if (SongsPickerFragment.cursor!=null) {
				SongsPickerFragment.cursor.close();
				SongsPickerFragment.cursor = null;
			}
			
			if (AlbumsPickerFragment.cursor!=null) {
				AlbumsPickerFragment.cursor.close();
				AlbumsPickerFragment.cursor = null;
			}
			
			if (ArtistsPickerFragment.cursor!=null) {
				ArtistsPickerFragment.cursor.close();
				ArtistsPickerFragment.cursor = null;
			}
			
		}
		
	}

