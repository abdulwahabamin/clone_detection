    @Override
    protected void onNewIntent(Intent intent) {
        // If an activity is requesting access to this activity, and
        // the activity is in the stack, the the fragments may need
        // be refreshed. Update the page adapter
        if (mPagerAdapter != null) {
            mPagerAdapter.refresh();
        }
        super.onNewIntent(intent);
    }

