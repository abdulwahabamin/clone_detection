    public List<MediaMetadataCompat> searchAlbums(String query, int limit) {
        FireLog.d(TAG, "(++) searchAlbums");
        List<MediaMetadataCompat> albums = new ArrayList<>();

        Uri albumUri = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
        String[] projection = {"*"};
        String selection = MediaStore.Audio.Albums.ALBUM + " LIKE ?";
        String[] selectionArgs = {"%" + query + "%"};
        String sortOrder = MediaStore.Audio.Albums.ALBUM + " ASC LIMIT " + limit;

        Cursor cursor = FireApplication.getInstance().getContentResolver().
                query(albumUri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    MediaMetadataCompat mediaMetadataCompat = new MediaMetadataCompat.Builder()
                            .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID,
                                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums._ID)))
                            .putString(MediaMetadataCompat.METADATA_KEY_TITLE,
                                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM)))
                            .putString(MediaMetadataCompat.METADATA_KEY_ARTIST,
                                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)))
                            .putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI,
                                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART)))
                            .build();
                    albums.add(mediaMetadataCompat);
                } while (cursor.moveToNext());
            }
            cursor.close();

        }
        return albums;
    }

