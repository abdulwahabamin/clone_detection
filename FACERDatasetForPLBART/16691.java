    private String getAlbumArt(int albumId) {
        FireLog.d(TAG, "(++) getAlbumArt, albumArt= " + albumId);

        return ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), albumId).toString();
//        String albumArt = null;
//        Uri albumUri = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
//        String[] projection = {MediaStore.Audio.Albums.ALBUM_ART};
//        String selection = MediaStore.Audio.Albums._ID + " == ?";
//        String[] selectionArgs = {albumId + ""};
//
//        Cursor cursor = FireApplication.getInstance().getContentResolver()
//                .query(albumUri, projection, selection, selectionArgs, null);
//        if (cursor != null) {
//            if (cursor.moveToFirst()) {
//                albumArt = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART));
//            }
//            cursor.close();
//        }
//
//        return albumArt;
    }

