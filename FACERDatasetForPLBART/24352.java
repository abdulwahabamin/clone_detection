    private long fetchSongIdFromPath(String path) {
        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                new String[] {MediaStore.Audio.Media._ID},
                MediaStore.Audio.Media.DATA + "=?",
                new String[] {path},
                null);
        if (cursor == null) {
            Log.w(LOGTAG, "Unable to fetch Song Id (cursor is null) for " + path);
            return -1;
        }
        try {
            if (cursor.moveToFirst()) {
                return cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
            } else {
                Log.w(LOGTAG, "Unable to fetch Song Id (cursor is empty) for " + path);
                return -1;
            }
        } finally {
            cursor.close();
        }
    }

