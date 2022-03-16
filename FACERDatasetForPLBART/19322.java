    /**
     * Toggles the open/closed state of the current queue drawer.
     */
	public void toggleCurrentQueueDrawer() {
        if (mDrawerLayout==null)
            return;

        if (mDrawerLayout.isDrawerOpen(Gravity.END))
            mDrawerLayout.closeDrawer(Gravity.END);
        else
            mDrawerLayout.openDrawer(Gravity.END);

    }

