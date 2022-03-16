    /**
     * this method is defined in fragment because of attached onclicklistener
     * @param artistList
     * @return
     */
    private List<BaseVisitable> getVisitableList(List<MediaBrowserCompat.MediaItem> artistList) {
        List<BaseVisitable> visitableList = new ArrayList<>();
        for (MediaBrowserCompat.MediaItem item : artistList) {
            ArtistVisitable artistVisitable = new ArtistVisitable(item);
            artistVisitable.setOnClickListener(artistOnClickListener);
            visitableList.add(artistVisitable);
        }

        return visitableList;
    }

