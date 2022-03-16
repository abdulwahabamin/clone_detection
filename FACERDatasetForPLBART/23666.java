    @Override
    public void onDestroy() {
        MusicUtils.unbindFromService(this);
        try {
            if ("nowplaying".equals(mPlaylist)) {
                unregisterReceiverSafe(mNowPlayingListener);
            } else {
                unregisterReceiverSafe(mTrackListListener);
            }
        } catch (IllegalArgumentException ex) {
            // we end up here in case we never registered the listeners
        }

        // if we didn't send the adapter off to another activity, we should
        // close the cursor
        if (!mAdapterSent && (mAdapter != null)) {
            Cursor c = mAdapter.getCursor();
            if (c != null) {
                c.close();
            }
        }
        if (mAdapter != null) {
            mAdapter.getQueryHandler().removeCallbacksAndMessages(null);
        }
        mReScanHandler.removeCallbacksAndMessages(null);
        // Because we pass the adapter to the next activity, we need to make
        // sure it doesn't keep a reference to this activity. We can do this
        // by clearing its DatasetObservers, which setListAdapter(null) does.
        setListAdapter(null);
        mAdapter = null;
        mAdapterDestroyed = true;
        unregisterReceiverSafe(mScanListener);
        super.onDestroy();
    }

