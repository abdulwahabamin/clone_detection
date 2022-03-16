    /**
     * Gather roots from storage providers belonging to given package name.
     */
    public void updatePackageAsync(String packageName) {
        // Need at least first load, since we're going to be using previously
        // cached values for non-matching packages.
        waitForFirstLoad();
        new UpdateTask(packageName).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

