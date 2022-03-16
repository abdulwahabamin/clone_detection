    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        menu.add(mFragmentGroupId, PLAY_SELECTION, 0, getResources().getString(R.string.play_all));
        mCurrentId = mCursor.getString(mCursor.getColumnIndexOrThrow(BaseColumns._ID));
        String title = mCursor.getString(mCursor.getColumnIndexOrThrow(Audio.Genres.NAME));
        menu.setHeaderTitle(title);
    }

