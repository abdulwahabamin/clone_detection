    private List<MediaMetadataCompat> getTracksBySubCategory(String category, String subCategory) {
        FireLog.d(TAG, "(++) getTracksBySubCategory, category=" + category + ", subCategory=" + subCategory);

        if (category == null || subCategory == null) {
            return null;
        }

        List<MediaMetadataCompat> medias = new ArrayList<>();

        Uri songsUri = getUri(category, subCategory);
        String[] projection = getProjection(category, subCategory);
        String selection = getSelection(category, subCategory);
        String[] selectionArgs = null;
        String sortOrder = MediaStore.Audio.Media.TITLE + " ASC";
        String idColumnName = get_IDColumnName(category);

        Cursor cursor = FireApplication.getInstance().getContentResolver()
                .query(songsUri, projection, selection, selectionArgs, sortOrder);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    MediaMetadataCompat mediaMetadataCompat = new MediaMetadataCompat.Builder()
                            .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID,
                                    cursor.getString(cursor.getColumnIndex(idColumnName)))
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

