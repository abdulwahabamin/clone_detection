    @Override
    public void displayList(List<MediaBrowserCompat.MediaItem> itemList) {
        songsRv.setAdapter(
                new MediaRecyclerViewAdapter(getVisitableList(itemList),
                        new MediaListTypeFactory()));
    }

