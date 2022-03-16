    @Override
    protected void initData() {
        mAdapter = new AddFriendAdapter(mContext);
        mAddFriendLv.setAdapter(mAdapter);
        beginDiscover();
    }

