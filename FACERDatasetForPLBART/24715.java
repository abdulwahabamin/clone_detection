    @Override
    protected ArrayList<MediaItem> doInBackground(Void... params) {
        final String sortOrder = MediaStore.Audio.AudioColumns.TITLE + " COLLATE LOCALIZED ASC";
        Cursor mCursor = MediaStoreAccessHelper.getAllSongs(mContext,null,sortOrder);
        ArrayList<MediaItem> listOfSongs = new ArrayList<MediaItem>();
        mCursor.moveToFirst();
        final int titleColIndex = mCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
        final int artistColIndex = mCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
        final int albumColIndex = mCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
        final int durationColIndex = mCursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
        final int filePathColIndex = mCursor.getColumnIndex(MediaStore.Audio.Media.DATA);
        final int albumIdColIndex = mCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID);
        final Uri sArtworkUri = Uri.parse("content://media/external/audio/albumart");

        do {
            MediaItem songData = new MediaItem();

            String title = mCursor.getString(titleColIndex);
            String artist = mCursor.getString(artistColIndex);
            String album = mCursor.getString(albumColIndex);
            long duration = mCursor.getLong(durationColIndex);
            String filePath= mCursor.getString(filePathColIndex);
            long albumId=mCursor.getLong(albumIdColIndex);
            Uri uri = ContentUris.withAppendedId(sArtworkUri, albumId);

            songData.setTitle(title);
            songData.setAlbum(album);
            songData.setArtist(artist);
            songData.setDuration(duration);
            songData.setFilepath(filePath);
            songData.setAlbumId(albumId);
            songData.setAlbumArtPath(uri);
            listOfSongs.add(songData);
        }while(mCursor.moveToNext());

        mCursor.close();
        return listOfSongs;
    }

