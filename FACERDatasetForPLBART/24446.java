    private boolean removePlaylistItem(int which) {
        View v = getListView().getChildAt(which - getListView().getFirstVisiblePosition());
        if (v == null) {
            Log.i(TAG, "No view when removing playlist item " + which);
            return false;
        }
        if (service != null && which != service.getQueuePosition()) {
            deletedOneRow = true;
        }
        v.setVisibility(View.GONE);
        getListView().invalidateViews();
        boolean ret = playQueueCursor.removeItem(which);
        listAdapter.notifyDataSetChanged();
        v.setVisibility(View.VISIBLE);
        getListView().invalidateViews();
        return ret;
    }

