    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        menu.add(mFragmentGroupId, PLAY_SELECTION, 0, getResources().getString(R.string.play_all));
        menu.add(mFragmentGroupId, ADD_TO_PLAYLIST, 0, getResources().getString(R.string.add_to_playlist));
        menu.add(mFragmentGroupId, SEARCH, 0, getResources().getString(R.string.search));

        mCurrentId = mCursor.getString(mCursor.getColumnIndexOrThrow(BaseColumns._ID));

        menu.setHeaderView(ApolloUtils.setHeaderLayout(mType, mCursor, getActivity()));
        super.onCreateContextMenu(menu, v, menuInfo);
    }

