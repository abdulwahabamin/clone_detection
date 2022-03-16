    private List<MediaMetadataCompat> getLocalArtists() {
        FireLog.d(TAG, "(++) getLocalArtists");
        List<MediaMetadataCompat> artists = new ArrayList<>();
        Uri albumUri = MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI;
        String[] projection = {"*"};
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = MediaStore.Audio.Artists.ARTIST + " ASC";

        Cursor cursor = FireApplication.getInstance().getContentResolver()
                .query(albumUri, projection, selection, selectionArgs, sortOrder);

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

