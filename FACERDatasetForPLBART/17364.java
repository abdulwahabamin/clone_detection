    @Override
    public List<MediaMetadataCompat> getAlbums() {
        Log.d(TAG, "getAlbums:called");
        if (mCurrentState != MusicProvider.State.INITIALIZED) {
            return Collections.emptyList();
        }

        return allAlbums;
    }

