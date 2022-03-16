    /**
     * Deserialize a json representation of an object.
     *
     * @param string A json string to fromJson.
     */
    public static <T> T fromJson(String string, Class<T> clazz) {
        return GSON.fromJson(string, clazz);
    }

