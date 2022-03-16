    private List<MediaMetadataCompat> getLocalPlayLists() {
        FireLog.d(TAG, "(++) getLocalPlayLists");

        List<MediaMetadataCompat> playlists = new ArrayList<>();
        Uri playlistUri = MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI;
        String[] projection = {"*"};
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = MediaStore.Audio.Playlists.NAME + " ASC";

        Cursor cursor = FireApplication.getInstance().getContentResolver()
                .query(playlistUri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    MediaMetadataCompat mediaMetadataCompat = new MediaMetadataCompat.Builder()
                            .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID,
                                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Playlists._ID)))
                            .putString(MediaMetadataCompat.METADATA_KEY_TITLE,
                                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Playlists.NAME)))
                            .build();
                    playlists.add(mediaMetadataCompat);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return playlists;
    }

