    /**
     * Get the metadata for an album on Last.fm using the album name or a
     * musicbrainz id. See playlist.fetch on how to get the album playlist.
     * 
     * @param artist Artist's name
     * @param albumOrMbid Album name or MBID
     * @param apiKey The API key
     * @return Album metadata
     */
    public static Album getInfo(String artist, String albumOrMbid, String apiKey) {
        return getInfo(artist, albumOrMbid, null, apiKey);
    }

