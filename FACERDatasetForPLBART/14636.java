    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {

        AdapterContextMenuInfo mi = (AdapterContextMenuInfo)menuInfo;

        menu.add(0, PLAY_SELECTION, 0, getResources().getString(R.string.play_all));

        if (mi.id >= 0) {
            menu.add(0, RENAME_PLAYLIST, 0, getResources().getString(R.string.rename_playlist));
            menu.add(0, DELETE_PLAYLIST, 0, getResources().getString(R.string.delete_playlist));
        }

        mCurrentPlaylistId = mCursor.getString(mCursor.getColumnIndexOrThrow(BaseColumns._ID));

        String title = mCursor.getString(mPlaylistNameIndex);
        menu.setHeaderTitle(title);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

