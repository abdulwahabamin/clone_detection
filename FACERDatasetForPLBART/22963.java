    /**
     * Check if the given url is a youtube url
     *
     * @param url the url
     * @return <code>true</code> if it's a Youtube URL
     */
    private boolean isYoutubeUrl(String url) {
        return url.contains("youtube.com") || url.contains("youtu.be");
    }

