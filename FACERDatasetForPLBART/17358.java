    /**
     * get all songs of an artist
     * @param artistKey key of the artist whose songs are required
     * @return iterable of songs of required artist
     */
    public abstract List<MediaMetadataCompat> getMusicsByArtistKey(@NonNull String artistKey);

