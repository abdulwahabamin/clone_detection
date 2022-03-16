    @Override
    public void onSearchQueryTextChange(String searchText) {
        if (searchText != null && !searchText.equals("")) {
            mMediaBrowserManager.search(searchText);
        } else {
            mMvpView.displaySearchResults(new ArrayList<MediaBrowserCompat.MediaItem>());
        }
    }

