    /**
     * for getting music by mediaid
     * @param musicId music id for which metadata will be returned
     * @return metadata of required musicid
     */
    public MediaMetadataCompat getMusic(@NonNull String musicId) {
        return mMusicListById.containsKey(musicId) ? mMusicListById.get(musicId) : null;
    }

