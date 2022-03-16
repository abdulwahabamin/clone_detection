    @Override
    public void onLibraryChanged(Cursor newCursor) {
        albumAdapter.changeCursor(newCursor);
        albumAdapter.notifyDataSetChanged();
        savedPosition = -1;
    }

