    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        AdapterContextMenuInfo mi = (AdapterContextMenuInfo)menuInfo;
        menu.add(mFragmentGroupId, PLAY_SELECTION, 0, getResources().getString(R.string.play_all));
        if (mi.id >= 0) {
            menu.add(mFragmentGroupId, RENAME_PLAYLIST, 0, getResources().getString(R.string.rename_playlist));
            menu.add(mFragmentGroupId, DELETE_PLAYLIST, 0, getResources().getString(R.string.delete_playlist));
        }
        mCurrentId = mCursor.getString(mCursor.getColumnIndexOrThrow(BaseColumns._ID));
        String title = mCursor.getString(mCursor.getColumnIndexOrThrow(PlaylistsColumns.NAME));
        menu.setHeaderTitle(title);
    }

