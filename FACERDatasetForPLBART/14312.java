    private String nameForId(long id) {

        Cursor cursor = MusicUtils.query(this, Audio.Playlists.EXTERNAL_CONTENT_URI, new String[] {
            Audio.Playlists.NAME
        }, Audio.Playlists._ID + "=?", new String[] {
            Long.valueOf(id).toString()
        }, Audio.Playlists.NAME);
        String name = null;
        if (cursor != null) {
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                name = cursor.getString(0);
            }
            cursor.close();
        }
        return name;
    }

