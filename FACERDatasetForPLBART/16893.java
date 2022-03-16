    protected void onMediaControllerConnected() {
        // call mediaList onConnected
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(SearchFragment.TAG);
        if (fragment != null) {
            ((SearchFragment) fragment).onConnected();
        }
        // connect activity to receive callback
        onConnected();
    }

