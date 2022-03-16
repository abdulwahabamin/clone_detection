    static Session sessionFromElement(DomElement element, String apiKey, String secret) {
        if (element == null)
            return null;
        String user = element.getChildText("name");
        String key = element.getChildText("key");
        boolean subsc = element.getChildText("subscriber").equals("1");
        return createSession(apiKey, secret, key, user, subsc);
    }

