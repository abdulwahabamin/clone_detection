    /**
     * Cursor should be positioned on the entry to be checked
     * Returns false if the entry matches the naming pattern used for recordings,
     * or if it is marked as not music in the database.
     */
    public static boolean isMusic(Cursor c) {
        int titleidx = c.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE);
        int albumidx = c.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM);
        int artistidx = c.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST);

        String title = c.getString(titleidx);
        String album = c.getString(albumidx);
        String artist = c.getString(artistidx);
        if (MediaStore.UNKNOWN_STRING.equals(album) &&
                MediaStore.UNKNOWN_STRING.equals(artist) &&
                title != null &&
                title.startsWith("recording")) {
            // not music
            return false;
        }

        int ismusic_idx = c.getColumnIndex(MediaStore.Audio.AudioColumns.IS_MUSIC);
        boolean ismusic = true;
        if (ismusic_idx >= 0) {
            ismusic = c.getInt(ismusic_idx) != 0;
        }
        return ismusic;
    }

