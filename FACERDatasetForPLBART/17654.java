    @Override
    public void displayList(List<MediaBrowserCompat.MediaItem> itemList) {
        artistsRv.setAdapter(
                new MediaRecyclerViewAdapter(getVisitableList(itemList),
                        new MediaListTypeFactory()));
    }

