    /**
     * Deletes a playlist from the grid view.
     *
     * @param title - Title of the playlist.
     * @param index - Index of the playlist cover to be deleted.
     */
    public void deletePlaylist(String title, int index){
        playlistMap.remove(title);
        playlistCovers.remove(index);
        fragmentCommunicator.savePlaylistHashMap(playlistMap);
        gridAdapter.notifyDataSetChanged();
        gridView.invalidateViews();
    }

