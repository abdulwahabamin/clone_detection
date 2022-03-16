    @Override
    public List<MediaMetadataCompat> getSongs() {
        Log.d(TAG, "getSongs:called");
        if (mCurrentState != MusicProvider.State.INITIALIZED) {
            return Collections.emptyList();
        }

        return allSongs;
    }

