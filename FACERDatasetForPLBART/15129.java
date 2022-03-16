    /**
     * Restores a Session instance with the given session key.
     * 
     * @param apiKey An api key
     * @param secret A secret
     * @param sessionKey The previously obtained session key
     * @return a Session instance
     */
    public static Session createSession(String apiKey, String secret, String sessionKey) {
        return createSession(apiKey, secret, sessionKey, null, false);
    }

