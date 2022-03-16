    private String makePlaylistName() {

        String template = getString(R.string.new_playlist_name_template);
        int num = 1;

        String[] cols = new String[] {
            Audio.Playlists.NAME
        };
        ContentResolver resolver = getContentResolver();
        String whereclause = Audio.Playlists.NAME + " != ''";
        Cursor cursor = resolver.query(MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI, cols,
                whereclause, null, Audio.Playlists.NAME);

        if (cursor == null)
            return null;

        String suggestedname;
        suggestedname = String.format(template, num++);

        // Need to loop until we've made 1 full pass through without finding a
        // match. Looping more than once shouldn't happen very often, but will
        // happen if you have playlists named
        // "New Playlist 1"/10/2/3/4/5/6/7/8/9, where making only one pass would
        // result in "New Playlist 10" being erroneously picked for the new
        // name.
        boolean done = false;
        while (!done) {
            done = true;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String playlistname = cursor.getString(0);
                if (playlistname.compareToIgnoreCase(suggestedname) == 0) {
                    suggestedname = String.format(template, num++);
                    done = false;
                }
                cursor.moveToNext();
            }
        }
        cursor.close();
        return suggestedname;
    };

