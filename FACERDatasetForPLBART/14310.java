    private int idForplaylist(String name) {

        Cursor cursor = MusicUtils.query(this, Audio.Playlists.EXTERNAL_CONTENT_URI, new String[] {
            Audio.Playlists._ID
        }, Audio.Playlists.NAME + "=?", new String[] {
            name
        }, Audio.Playlists.NAME, 0);
        int id = -1;
        if (cursor != null) {
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                id = cursor.getInt(0);
            }
            cursor.close();
        }

        return id;
    }

