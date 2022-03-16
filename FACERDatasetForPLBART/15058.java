    /**
    * Retrieves detailed artist info for the given artist or mbid entry.
    *
    * @param artistOrMbid Name of the artist or an mbid
    * @return detailed artist info
    */
    public final static Artist getInfo(final String artistOrMbid, String apiKey) {
        return getInfo(artistOrMbid, Locale.getDefault(), apiKey);
    }

