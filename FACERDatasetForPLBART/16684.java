    private List<MediaMetadataCompat> getLocalGenres() {
        FireLog.d(TAG, "(++) getLocalGenres");

        List<MediaMetadataCompat> genres = new ArrayList<>();
        Uri albumUri = MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI;
        String[] projection = {"*"};
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = MediaStore.Audio.Genres.NAME + " ASC";

        Cursor cursor = FireApplication.getInstance().getContentResolver()
                .query(albumUri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    MediaMetadataCompat mediaMetadataCompat = new MediaMetadataCompat.Builder()
                            .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID,
                                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Genres._ID)))
                            .putString(MediaMetadataCompat.METADATA_KEY_TITLE,
                                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Genres.NAME)))
                            .build();
                    genres.add(mediaMetadataCompat);
                } while (cursor.moveToNext());
            }
            cursor.close();

        }
        return genres;
    }

