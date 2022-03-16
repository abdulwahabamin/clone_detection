    /**
     * Produce a JSONArray of JSONObjects from a comma delimited text string
     * using a supplied JSONArray as the source of element names.
     * @param names A JSONArray of strings.
     * @param string The comma delimited text.
     * @return A JSONArray of JSONObjects.
     * @throws JSONException
     */
    public static JSONArray toJSONArray(JSONArray names, String string)
            throws JSONException {
        return toJSONArray(names, new JSONTokener(string));
    }

