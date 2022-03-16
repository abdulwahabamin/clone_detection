    /**
     * Loads the drawer fragments.
     */
    private void loadDrawerFragments() {
        //Load the navigation drawer.
        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.nav_drawer_container, new NavigationDrawerFragment())
                                   .commit();

        //Load the current queue drawer.
        mQueueDrawerFragment = new QueueDrawerFragment();
        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.current_queue_drawer_container, mQueueDrawerFragment)
                                   .commit();

    }

