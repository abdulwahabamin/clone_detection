    /**
     * converts mediaitem list to visitable list
     * @param albumList input list
     * @return output visitable list
     */
    private List<BaseVisitable> getVisitableList(List<MediaBrowserCompat.MediaItem> albumList) {
        List<BaseVisitable> visitableList = new ArrayList<>();
        for (MediaBrowserCompat.MediaItem item : albumList) {
            AlbumVisitable albumVisitable = new AlbumVisitable(item);
            albumVisitable.setOnClickListener(albumOnClickListener);
            visitableList.add(albumVisitable);
        }

        return visitableList;
    }

