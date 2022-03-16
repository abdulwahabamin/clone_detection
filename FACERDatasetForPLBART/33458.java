    /**
     * Parses the provided string to a valid web address, that can be used to fetch data.
     *
     * @param urlString specification for the URL
     * @return a new URL instance
     */
    private URL getUrl(String urlString) {
        URL url;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return url;
    }

