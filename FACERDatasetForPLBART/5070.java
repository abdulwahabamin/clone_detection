    /**
     * Construct a JSONTokener from an InputStream.
     */
    public JSONTokener(InputStream inputStream) throws JSONException {
        this(new InputStreamReader(inputStream));
    }

