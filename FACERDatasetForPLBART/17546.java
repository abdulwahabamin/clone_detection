    @Override
    public void displayList(List<MediaBrowserCompat.MediaItem> itemList) {
        albumsRv.setAdapter(
                new MediaRecyclerViewAdapter(getVisitableList(itemList),
                        new MediaListTypeFactory()));
    }

