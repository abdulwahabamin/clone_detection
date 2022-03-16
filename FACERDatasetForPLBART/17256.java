    public void search(String query) {
        mMediaBrowser.search(query, null, new MediaBrowserCompat.SearchCallback() {
            @Override
            public void onSearchResult(@NonNull String query,
                                       Bundle extras,
                                       @NonNull List<MediaBrowserCompat.MediaItem> items) {
                mMediaBrowserCallback.onSearchResult(items);
            }
        });
    }

