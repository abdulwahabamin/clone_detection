    /** Get album art for specified album. You should not pass in the album id
     * for the "unknown" album here (use -1 instead)
     */
    public static Bitmap getArtwork(Context context, int album_id) {
        return getArtwork(context, album_id, true);
    }

