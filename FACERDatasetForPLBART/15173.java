    /**
     * @param context
     * @param numalbums
     * @param numsongs
     * @param isUnknown
     * @return a string based on the number of albums for an artist or songs for
     *         an album
     */
    public static String makeAlbumsLabel(Context mContext, int numalbums, int numsongs,
            boolean isUnknown) {

        StringBuilder songs_albums = new StringBuilder();

        Resources r = mContext.getResources();
        if (isUnknown) {
            String f = r.getQuantityText(R.plurals.Nsongs, numsongs).toString();
            sFormatBuilder.setLength(0);
            sFormatter.format(f, Integer.valueOf(numsongs));
            songs_albums.append(sFormatBuilder);
            songs_albums.append("\n");
        } else {
            String f = r.getQuantityText(R.plurals.Nalbums, numalbums).toString();
            sFormatBuilder.setLength(0);
            sFormatter.format(f, Integer.valueOf(numalbums));
            songs_albums.append(sFormatBuilder);
            songs_albums.append("\n");
        }
        return songs_albums.toString();
    }

