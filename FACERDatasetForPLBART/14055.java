    @Override
    public Cursor loadInBackground() {

        Cursor mediaCursor = getContext().getContentResolver().query(mUri, mProjection, mSelection,
                mSelectionArgs, mSortOrder);
        //Get cursor filled with Audio Id's
        String [] projection =  new String[] {
                BaseColumns._ID, AlbumColumns.ALBUM
        };        
        Uri uri = Audio.Albums.EXTERNAL_CONTENT_URI;
        String sortOrder = Audio.Albums.DEFAULT_SORT_ORDER;
        Cursor albumCursor = getContext().getContentResolver().query(uri, projection, null, null, sortOrder);
        
        //Matrix cursor to hold final data to be returned to calling context
        MatrixCursor cursor = new MatrixCursor( new String[]
        		{ BaseColumns._ID, MediaColumns.TITLE, AudioColumns.ARTIST, AudioColumns.ALBUM, AudioColumns.ALBUM_ID});
        //Map data from Audio Id cursor to the ALbumName Colum
        ContentQueryMap mQueryMap = new ContentQueryMap(albumCursor, AlbumColumns.ALBUM, false, null);

		Map<String, ContentValues> data = mQueryMap.getRows();
        if (mediaCursor != null) {
            while(mediaCursor.moveToNext()) {
				String id = mediaCursor.getString(mediaCursor.getColumnIndexOrThrow(BaseColumns._ID));
				String title = mediaCursor.getString(mediaCursor.getColumnIndexOrThrow(MediaColumns.TITLE));
				String artist = mediaCursor.getString(mediaCursor.getColumnIndexOrThrow(AudioColumns.ARTIST));
				String album = mediaCursor.getString(mediaCursor.getColumnIndexOrThrow(AudioColumns.ALBUM));
					
				ContentValues tData = data.get(album);
				String albumid = (String) tData.get(BaseColumns._ID);
				cursor.addRow(new String[] {id, title, artist, album, albumid});
            }
            mediaCursor.close();
        }
        
        if (cursor != null) {
            // Ensure the cursor window is filled
            registerContentObserver(cursor, mObserver);
        }
        return cursor;
    }

