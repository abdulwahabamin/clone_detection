    /**
     * @param context
     * @param plid
     */
    public static void clearPlaylist(Context context, int plid) {
        Uri uri = Audio.Playlists.Members.getContentUri(EXTERNAL, plid);
        context.getContentResolver().delete(uri, null, null);
        return;
    }

