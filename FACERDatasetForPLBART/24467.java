    private void removePlaylistItem(int which) {
        View v = getListView().getChildAt(which - getListView().getFirstVisiblePosition());
        if (v != null) {
            v.setVisibility(View.GONE);
            getListView().invalidateViews();
        }
        removeItemFromPlaylist(which);
        if (v != null) {
            v.setVisibility(View.VISIBLE);
            getListView().invalidateViews();
        }
    }

