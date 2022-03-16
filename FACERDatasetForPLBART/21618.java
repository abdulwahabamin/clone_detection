    public static Cursor makeAlbumForArtistCursor(Context context, long artistID) {

        if (artistID == -1)
            return null;

        return context.getContentResolver()
                .query(MediaStore.Audio.Artists.Albums.getContentUri("external", artistID),
                        new String[]{"_id", "album", "artist", "numsongs", "minyear"},
                        null,
                        null,
                        MediaStore.Audio.Albums.FIRST_YEAR);
    }

