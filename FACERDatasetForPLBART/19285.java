    /**
     * Initializes the current queue drawer/layout.
     */
    private void initDrawer() {
        //Load the current queue drawer.
        mQueueDrawerFragment = new QueueDrawerFragment();

        try {
            getSupportFragmentManager().beginTransaction()
                                       .replace(R.id.queue_drawer, mQueueDrawerFragment)
                                       .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                                       .commit();

        } catch (IllegalStateException e) {
            /*
             * Catches any exceptions that may occur if the
             * user rapidly changes the device's orientation.
             */
            e.printStackTrace();
        }

    }

