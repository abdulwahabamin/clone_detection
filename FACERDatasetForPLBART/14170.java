    /**
     * Restores a Session instance with the given session key.
     * 
     * @param apiKey An api key
     * @param secret A secret
     * @param sessionKey The previously obtained session key
     * @param username A Last.fm username
     * @param subscriber Subscriber status
     * @return a Session instance
     */
    public static Session createSession(String apiKey, String secret, String sessionKey,
            String username, boolean subscriber) {
        Session s = new Session();
        s.apiKey = apiKey;
        s.secret = secret;
        s.key = sessionKey;
        s.username = username;
        s.subscriber = subscriber;
        return s;
    }

