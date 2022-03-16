    /**
     * getting songs, albums and artists for given search string
     * @param query search string
     * @return list of matching items
     */
    public abstract List<MediaBrowserCompat.MediaItem> getItemsBySearchQuery(@NonNull String query);

