    public List<MediaMetadataCompat> searchTracks(String query, int limit) {
        FireLog.d(TAG, "(++) searchTracks");

        List<MediaMetadataCompat> medias = new ArrayList<>();
        Uri songsUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {"*"};
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != ? AND " + MediaStore.Audio.Media.TITLE + " LIKE ?";
        String[] selectionArgs = {"0", "%" + query + "%"};
        String sortOrder = MediaStore.Audio.Media.TITLE + " ASC LIMIT " + limit;

        Cursor cursor = FireApplication.getInstance().getContentResolver()
                .query(songsUri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    MediaMetadataCompat mediaMetadataCompat = new MediaMetadataCompat.Builder()
                            .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID,
                                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID)))
                            .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_URI,
                                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA)))
                            .putString(MediaMetadataCompat.METADATA_KEY_TITLE,
                                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)))
                            .putString(MediaMetadataCompat.METADATA_KEY_ARTIST,
                                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)))
                            .putLong(MediaMetadataCompat.METADATA_KEY_DURATION,
                                    cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)))
                            .putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI,
                                    getAlbumArt(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID))))
                            .build();
                    medias.add(mediaMetadataCompat);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }

        return medias;
    }

