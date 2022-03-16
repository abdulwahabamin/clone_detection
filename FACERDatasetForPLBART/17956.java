    /**
     * this method is defined in fragment because of attached onclicklistener
     * @param songList
     * @return
     */
    private List<BaseVisitable> getVisitableList(List<MediaBrowserCompat.MediaItem> songList) {
        List<BaseVisitable> visitableList = new ArrayList<>();

        for (MediaBrowserCompat.MediaItem item : songList) {
            PlaylistVisitable visitable= new PlaylistVisitable(item);
            visitable.setOnClickListener(playlistOnClickListener);
            visitableList.add(visitable);
        }

        return visitableList;
    }

