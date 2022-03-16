    @Override
    public void onSearch(@NonNull String query,
                         Bundle extras,
                         @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {
        Log.d(TAG, "onLoadChildren:called");
        result.sendResult(mMusicProvider.getItemsBySearchQuery(query));
    }

