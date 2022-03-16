    @Override
    public void onDestroy() {
        MusicUtils.unbindFromService(this);
        unregisterReceiver(mScanListener);
        super.onDestroy();
        if (!mAdapterSent && mAdapter != null) {
            Cursor c = mAdapter.getCursor();
            if (c != null) {
                c.close();
            }
        }
        // Because we pass the adapter to the next activity, we need to make
        // sure it doesn't keep a reference to this activity. We can do this
        // by clearing its DatasetObservers, which setListAdapter(null) does.
        setListAdapter(null);
        mAdapter = null;
        mAdapterDestroyed = true;
    }

