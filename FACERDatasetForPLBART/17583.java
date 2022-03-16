    /**
     * this method is defined in fragment because of attached onclicklistener
     * @param songList
     * @return
     */
    private List<BaseVisitable> getVisitableList(List<MediaBrowserCompat.MediaItem> songList) {
        List<BaseVisitable> visitableList = new ArrayList<>();
        ShuffleAllSongsVisitable visitable = new ShuffleAllSongsVisitable();
        visitable.setOnClickListener(shuffleAllOnClickListener);
        visitableList.add(visitable);

        for (MediaBrowserCompat.MediaItem item : songList) {
            SongVisitable songVisitable = new SongVisitable(item);
            songVisitable.setOnClickListener(songOnClickListener);
            visitableList.add(songVisitable);
        }

        return visitableList;
    }

