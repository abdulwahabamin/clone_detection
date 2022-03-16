    @Override
    public List<MediaMetadataCompat> getMusicsByArtistKey(@NonNull String artistKey) {
        Log.d(TAG, "getMusicsByArtistKey:called");
        if (mCurrentState != MusicProvider.State.INITIALIZED || !mMusicListByArtistKey.containsKey(artistKey)) {
            return Collections.emptyList();
        }
        return mMusicListByArtistKey.get(artistKey);
    }

