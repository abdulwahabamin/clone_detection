    @Override
    protected void onMediaControllerConnected() {

        // connect CategoryFragment
        Fragment fragmentCategory = getCategoryFragment();
        if (fragmentCategory != null) {
            ((CategoryFragment) fragmentCategory).onConnected();
        }

        // connect MediaListFragment
        Fragment fragment = getMediaListFragment();
        if (fragment != null) {
            ((MediaListFragment) fragment).onConnected();
        }

        Fragment fragmentControl = getControlFragment();
        if (fragmentControl != null) {
            ((PlaybackControlsFragment) fragmentControl).onConnected();
        }

        // connect activity to receive callback
        this.onConnected();
    }

