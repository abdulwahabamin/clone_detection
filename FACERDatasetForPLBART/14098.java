    /**
     * Get {@link Image}s for this artist in a variety of sizes.
     * 
     * @param artistOrMbid The artist name in question
     * @param apiKey A Last.fm API key
     * @return a list of {@link Image}s
     */
    public static PaginatedResult<Image> getImages(String artistOrMbid, String apiKey) {
        return getImages(artistOrMbid, -1, -1, apiKey);
    }

