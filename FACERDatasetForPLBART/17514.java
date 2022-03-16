    /**
     * converts mediaitem list to visitable list
     * @param songList input list
     * @return visitable list
     */
    private List<BaseVisitable> getVisitableList(MediaBrowserCompat.MediaItem item,
                                                 Palette.Swatch swatch,
                                                 List<MediaBrowserCompat.MediaItem> songList) {
        Log.d(TAG, "getVisitableList:called");

        List<BaseVisitable> visitableList = new ArrayList<>();

        int backgroundColor = ColorUtil.getBackgroundColor(swatch);
        int titleColor = ColorUtil.getTitleColor(swatch);
        int bodyColor = ColorUtil.getBodyColor(swatch);

        DetailTitleVisitable detailTitleVisitable = new DetailTitleVisitable(item);
        detailTitleVisitable.setBackgroundColor(backgroundColor);
        detailTitleVisitable.setTitleTextColor(titleColor);
        detailTitleVisitable.setSubtitleTextColor(bodyColor);
        visitableList.add(detailTitleVisitable);

        for (MediaBrowserCompat.MediaItem songItem : songList) {
            AlbumSongVisitable visitable = new AlbumSongVisitable(songItem);
            visitable.setOnClickListener(songOnClickListener);
            visitableList.add(visitable);
        }

        return visitableList;
    }

