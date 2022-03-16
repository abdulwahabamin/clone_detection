    public List<MediaMetadataCompat> searchArtists(String query, int limit) {
        FireLog.d(TAG, "(++) searchArtists");
        List<MediaMetadataCompat> artists = new ArrayList<>();

        Uri albumUri = MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI;
        String[] projection = {"*"};
        String selection = MediaStore.Audio.Artists.ARTIST + " LIKE ?";
        String[] selectionArgs = {"%" + query + "%"};
        String sortOrder = MediaStore.Audio.Artists.ARTIST + " ASC LIMIT " + limit;

        Cursor cursor = FireApplication.getInstance().getContentResolver().
                query(albumUri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    MediaMetadataCompat mediaMetadataCompat = new MediaMetadataCompat.Builder()
                            .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID,
                                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Artists._ID)))
                            .putString(MediaMetadataCompat.METADATA_KEY_TITLE,
                                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Artists.ARTIST)))
                            .build();
                    artists.add(mediaMetadataCompat);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }

        return artists;
    }

