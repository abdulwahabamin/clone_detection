	@Override
	public void onPause() {
		super.onPause();
		songIdBlacklistStatusPair.clear();
		
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

