    /**
     * Get the metadata for an album on Last.fm using the album name or a
     * musicbrainz id. See playlist.fetch on how to get the album playlist.
     * 
     * @param artist Artist's name
     * @param albumOrMbid Album name or MBID
     * @param username The username for the context of the request. If supplied,
     *            the user's playcount for this album is included in the
     *            response.
     * @param apiKey The API key
     * @return Album metadata
     */
    public static Album getInfo(String artist, String albumOrMbid, String username, String apiKey) {
        Map<String, String> params = new HashMap<String, String>();
        if (StringUtilities.isMbid(albumOrMbid)) {
            params.put("mbid", albumOrMbid);
        } else {
            params.put("artist", artist);
            params.put("album", albumOrMbid);
        }
        if (username != null) {
        	params.put("username", username);
		}
        Result result = Caller.getInstance().call("album.getInfo", apiKey, params);
        return ResponseBuilder.buildItem(result, Album.class);
    }

