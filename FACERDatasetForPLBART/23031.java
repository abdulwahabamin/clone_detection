	private void loadSongsOfAlbum() {
		if (album != null) {
			if (contentResolver != null) {
				if (songsArrayAdap != null)
					songsArrayAdap.clear();
				Cursor cursor = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[] {
						MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media._ID }, MediaStore.Audio.Media.ALBUM_KEY
						+ " LIKE ?", new String[] { album.getKey() }, MediaStore.Audio.Media.TITLE + " ASC");
				if (cursor == null) {
					Log.e(getActivity().getLocalClassName(), "Error querying songs for album '" + album.getTitle()
							+ "', cursor is null");
				} else if (!cursor.moveToFirst()) {
					Log.i(getActivity().getLocalClassName(),
							"There aren't songs in the device for album " + album.getTitle());
					cursor.close();
				} else {
					int songTitleColumn = cursor.getColumnIndex(android.provider.MediaStore.Audio.Media.TITLE);
					int songIdColumn = cursor.getColumnIndex(android.provider.MediaStore.Audio.Media._ID);
					do {
						String songTitle = cursor.getString(songTitleColumn);
						int id = cursor.getInt(songIdColumn);
						if (songsArrayAdap != null) {
							Song song = playQueue.getSongById(id);
							if (song == null)
								song = new Song(id, songTitle, album);
							songsArrayAdap.add(song);
						}
					} while (cursor.moveToNext());
					songsArrayAdap.notifyDataSetChanged();
					cursor.close();
				}
			}
		} else {
			Log.e(getActivity().getLocalClassName(), "The album object is null");
		}
	}

