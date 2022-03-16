	private void loadAlbums() {
		if (contentResolver != null) {
			if (albumsArrayAdapter != null)
				albumsArrayAdapter.clear();
			Cursor cursor = contentResolver.query(MediaStore.Audio.Albums.getContentUri("external"), new String[] {
					MediaStore.Audio.Albums.ARTIST, MediaStore.Audio.Albums.ALBUM_KEY,
					MediaStore.Audio.Albums.NUMBER_OF_SONGS, MediaStore.Audio.Albums.ALBUM }, null, null,
					MediaStore.Audio.Albums.ALBUM + " ASC");
			if (cursor == null) {
				Log.e(getActivity().getLocalClassName(), "Error querying albums, cursor is null");
			} else if (!cursor.moveToFirst()) {
				Log.i(getActivity().getLocalClassName(), "There aren't albums in the device");
			} else {
				int albumIdColumn = cursor.getColumnIndex(android.provider.MediaStore.Audio.Albums.ALBUM_KEY);
				int artistColumn = cursor.getColumnIndex(android.provider.MediaStore.Audio.Albums.ARTIST);
				int numSongsColumn = cursor.getColumnIndex(android.provider.MediaStore.Audio.Albums.NUMBER_OF_SONGS);
				int albumCloumn = cursor.getColumnIndex(android.provider.MediaStore.Audio.Albums.ALBUM);
				do {
					String albumkey = cursor.getString(albumIdColumn);
					String artist = cursor.getString(artistColumn);
					int numSongs = cursor.getInt(numSongsColumn);
					String album = cursor.getString(albumCloumn);
					if (albumsArrayAdapter != null) {
						albumsArrayAdapter.add(new Album(albumkey, album, artist, numSongs));
					}
				} while (cursor.moveToNext());
				albumsArrayAdapter.notifyDataSetChanged();
				cursor.close();
			}

		}
	}

