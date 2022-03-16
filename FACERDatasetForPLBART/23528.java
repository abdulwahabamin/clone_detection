    public static void playPlaylist(Context context, long plid) {
        int [] list = getSongListForPlaylist(context, plid);
        if (list != null) {
            playAll(context, list, -1, false);
        }
    }

