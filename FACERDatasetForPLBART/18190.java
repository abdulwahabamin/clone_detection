    /**
     * Builds a HashMap of all albums and their individual songs count.
     */
    private void buildAlbumsLibrary() {
        Cursor albumsCursor = mContext.getContentResolver().query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
                                       new String[] { MediaStore.Audio.Albums.ALBUM, MediaStore.Audio.Albums.ARTIST, MediaStore.Audio.Albums.NUMBER_OF_SONGS },
                                       null,
                                       null,
                                       null);

        if (albumsCursor==null)
            return;

        for (int i=0; i < albumsCursor.getCount(); i++) {
            albumsCursor.moveToPosition(i);
            mSongsCountMap.put(albumsCursor.getString(0) + albumsCursor.getString(1), albumsCursor.getInt(2));

        }

        albumsCursor.close();
    }

