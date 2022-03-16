    @Override public void onStop() {
        super.onStop();
        
        // We don't want the list to display the empty state, since when we
        // resume it will still be there and show up while the new query is
        // happening. After the async query finishes in response to onResume()
        // setLoading(false) will be called.
        mAdapter.setLoading(true);
        mAdapter.changeCursor(null);
    }

