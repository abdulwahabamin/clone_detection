    public static List<Artist> getArtists(Context context, String paramString, int limit) {
        List<Artist> result = getArtistsForCursor(makeArtistCursor(context, "artist LIKE ?", new String[]{paramString + "%"}));
        if (result.size() < limit) {
            result.addAll(getArtistsForCursor(makeArtistCursor(context, "artist LIKE ?", new String[]{"%_" + paramString + "%"})));
        }
        return result.size() < limit ? result : result.subList(0, limit);
    }

