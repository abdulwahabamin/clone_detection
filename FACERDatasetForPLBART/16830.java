    @Override
    protected void onMediaControllerConnected() {
        super.onMediaControllerConnected();
        FireLog.d(TAG, "(++) onMediaControllerConnected");

        // connect MediaListFragment
        Fragment fragment = getMediaListFragment();
        if (fragment != null) {
            ((MediaListFragment) fragment).onConnected();
        }

        Fragment fragmentControl = getControlFragment();
        if (fragmentControl != null) {
            ((PlaybackControlsFragment) fragmentControl).onConnected();
        }

        this.onConnected();
    }

