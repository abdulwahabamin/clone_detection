    public static IdAndName fetchGenre(Context context, long songId) {
        Cursor c = context.getContentResolver().query(
                Uri.parse("content://media/external/audio/media/" + String.valueOf(songId) + "/genres"),
                new String[]{MediaStore.Audio.Genres._ID, MediaStore.Audio.Genres.NAME},
                null,
                null,
                null);
        if (c != null) {
            try {
                if (c.moveToFirst()) {
                    return new IdAndName(
                            c.getLong(c.getColumnIndexOrThrow(MediaStore.Audio.Genres._ID)),
                            ID3Utils.decodeGenre(c.getString(c.getColumnIndexOrThrow(MediaStore.Audio.Genres.NAME))));
                } else {
                    return null;
                }
            } finally {
                c.close();
            }
        } else {
            return null;
        }
    }

