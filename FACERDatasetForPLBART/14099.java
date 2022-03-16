    /**
     * Get {@link Image}s for this artist in a variety of sizes.
     * 
     * @param artistOrMbid The artist name in question
     * @param page Which page of limit amount to display
     * @param limit How many to return. Defaults and maxes out at 50
     * @param apiKey A Last.fm API key
     * @return a list of {@link Image}s
     */
    public static PaginatedResult<Image> getImages(String artistOrMbid, int page, int limit,
            String apiKey) {
        Map<String, String> params = new HashMap<String, String>();
        if (StringUtilities.isMbid(artistOrMbid)) {
            params.put("mbid", artistOrMbid);
        } else {
            params.put("artist", artistOrMbid);
        }
        if (page != -1) {
        	params.put("page", Integer.toString(page));
		}
        if (limit != -1) {
        	params.put("limit", Integer.toString(limit));
		}     
        Result result = Caller.getInstance().call("artist.getImages", apiKey, params);
        return ResponseBuilder.buildPaginatedResult(result, Image.class);
    }

