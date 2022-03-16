    /**
     * Convert a JSONObject into a well-formed, element-normal XML string.
     * @param object A JSONObject.
     * @return  A string.
     * @throws  JSONException
     */
    public static String toString(Object object) throws JSONException {
        return toString(object, null);
    }

