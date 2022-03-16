    /**
     * Throw an exception if the string contains whitespace.
     * Whitespace is not allowed in tagNames and attributes.
     * @param string
     * @throws JSONException
     */
    public static void noSpace(String string) throws JSONException {
        int i, length = string.length();
        if (length == 0) {
            throw new JSONException("Empty string.");
        }
        for (i = 0; i < length; i += 1) {
            if (Character.isWhitespace(string.charAt(i))) {
                throw new JSONException("'" + string +
                        "' contains a space character.");
            }
        }
    }

