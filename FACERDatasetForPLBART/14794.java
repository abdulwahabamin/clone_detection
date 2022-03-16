    /**
     * Adds a new playlist cover in the grid view.
     *
     * @param title - Title of the newly created playlist.
     */
    public void addToPlaylistList(String title){
        playlistCovers.add(playlistCovers.size(), new ImageItem(bitmap, title));
        gridAdapter.notifyDataSetChanged();
        gridView.invalidateViews();
    }

