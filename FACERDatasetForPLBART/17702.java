    @Override
    public void displaySearchResults(List<MediaBrowserCompat.MediaItem> itemList) {
        searchResultsRv.setAdapter(
                new MediaRecyclerViewAdapter(getVisitableList(itemList),
                        new MediaListTypeFactory()));
        searchResultsRv.invalidate();
    }

