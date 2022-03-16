    /**
     * Builds a HashMap of all albums and their album art path.
     */
    private void buildMediaStoreAlbumArtHash() {
        Cursor albumsCursor = mContext.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                new String[] { MediaStore.Audio.Media.ALBUM_ID },
                MediaStore.Audio.Media.IS_MUSIC + "=1",
                null,
                null);

        final Uri ART_CONTENT_URI = Uri.parse("content://media/external/audio/albumart");
        if (albumsCursor==null)
            return;

        for (int i=0; i < albumsCursor.getCount(); i++) {
            albumsCursor.moveToPosition(i);
            Uri albumArtUri = ContentUris.withAppendedId(ART_CONTENT_URI, albumsCursor.getLong(0));
            mMediaStoreAlbumArtMap.put(albumsCursor.getString(0), albumArtUri);
        }

        albumsCursor.close();
    }

