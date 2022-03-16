    /**
    * Retrieves detailed artist info for the given artist or mbid entry.
    *
    * @param artistOrMbid Name of the artist or an mbid
    * @param locale The language to fetch info in, or <code>null</code>
    * @param apiKey The API key
    * @return detailed artist info
    */
    public final static Artist getInfo(final String artistOrMbid,
            final Locale locale, final String apiKey) {
        final Map<String, String> mParams = new WeakHashMap<String, String>();
        mParams.put("artist", artistOrMbid);
        if (locale != null && locale.getLanguage().length() != 0) {
            mParams.put("lang", locale.getLanguage());
        }
        final Result mResult = Caller.getInstance().call("artist.getInfo", apiKey, mParams);
        return ResponseBuilder.buildItem(mResult, Artist.class);
    }

