    private void loadView(List<MediaBrowserCompat.MediaItem> mediaItems) {
        // not taking care of recyclerView visibility
        if (mediaItems == null || mediaItems.size() == 0) {
            getView().findViewById(R.id.error_view).setVisibility(View.VISIBLE);
        } else {
            getView().findViewById(R.id.error_view).setVisibility(View.GONE);
        }
        adapter.refreshData(mediaItems);
    }

