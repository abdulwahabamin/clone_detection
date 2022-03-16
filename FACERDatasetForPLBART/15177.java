    /**
     * @param context
     * @param cursor
     */
    public static void shuffleAll(Context context, Cursor cursor) {

        long[] list = getRandomSongListForCursor(cursor);
        playAll(context, list, -1, false);
    }

