    /**
     * get all songs of an album
     * @param albumKey key of the album whose songs are required
     * @return iterable of songs of required album
     */
    public abstract List<MediaMetadataCompat> getMusicsByAlbumKey(@NonNull String albumKey);

