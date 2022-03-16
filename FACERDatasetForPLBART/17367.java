    @Override
    public List<MediaMetadataCompat> getMusicsByAlbumKey(@NonNull String albumKey) {
        Log.d(TAG, "getMusicsByAlbumKey:called");
        if (mCurrentState != MusicProvider.State.INITIALIZED || !mMusicListByAlbumKey.containsKey(albumKey)) {
            return Collections.emptyList();
        }
        return mMusicListByAlbumKey.get(albumKey);
    }

