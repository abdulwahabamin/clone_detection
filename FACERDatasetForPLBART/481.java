    @Override
    protected void initWidget() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ((TextView)findViewById(R.id.title)).setText(getString(R.string.add_friend));

        mProgressDialog = new ProgressDialog(mContext);
        mScanPb = (ProgressBar) findViewById(R.id.add_friend_scan_progress);
        mAddFriendLv = (ListView) findViewById(R.id.add_friend_scan_list);
    }

