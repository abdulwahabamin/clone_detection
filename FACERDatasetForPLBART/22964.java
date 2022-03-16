    /**
     * Convert a url to the API to download url with the web api
     *
     * @param url which be shared by the app
     * @return The URL to open
     */
    private String convertUrl(String url) {
        return isYoutubeUrl(url) ? API + url : null;
    }

