    private Cursor fetchPlaylist(long id) {
        if (id == MusicContract.Playlist.ALL_SONGS) {
            return fetchMusic();
        } else if (id == MusicContract.Playlist.RECENTLY_ADDED_PLAYLIST) {
            // do a query for all songs added in the last X weeks
            Context context = getContext();
            int weeks = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE).getInt(SettingsActivity.NUMWEEKS, 2);
            int seconds = weeks * (3600 * 24 * 7);
            return getContext().getContentResolver().query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    MEDIA_STORE_MEMBER_CURSOR_COLS,
                    MediaStore.Audio.AudioColumns.TITLE + " != ''"
                            + " AND " + MediaStore.Audio.AudioColumns.DATA + " IS NOT NULL"
                            + " AND " + MediaStore.Audio.AudioColumns.DATA + " != ''"
                            + " AND " + MediaStore.Audio.AudioColumns.DATE_ADDED + ">" + (System.currentTimeMillis() / 1000 - seconds)
                            + " AND " + MediaStore.Audio.AudioColumns.IS_MUSIC + "=1",
                    null,
                    MediaStore.Audio.Media.DEFAULT_SORT_ORDER
            );
        } else {
            return getContext().getContentResolver().query(
                    MediaStore.Audio.Playlists.Members.getContentUri("external", id),
                    MEDIA_STORE_PLAYLIST_MEMBER_CURSOR_COLS,
                    null,
                    null,
                    MediaStore.Audio.Playlists.Members.DEFAULT_SORT_ORDER);
        }
    }

