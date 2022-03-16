    /**
     * Method that changes the current directory of the view.
     *
     * @param newDir The new directory location
     * @param addToHistory Add the directory to history
     * @param reload Force the reload of the data
     * @param useCurrent If this method must use the actual data (for back actions)
     * @param searchInfo The search information (if calling activity is {@link "SearchActivity"})
     * @param scrollTo If not null, then listview must scroll to this item
     */
    private void changeCurrentDir(
            final String newDir, final boolean addToHistory,
            final boolean reload, final boolean useCurrent,
            final SearchInfoParcelable searchInfo, final FileSystemObject scrollTo) {
        if (mNavigationTask != null) {
            this.mCurrentDir = this.mPreviousDir;
            this.mPreviousDir = null;
            mNavigationTask.cancel(true);
            mNavigationTask = null;
        }

        this.mPreviousDir = this.mCurrentDir;
        this.mCurrentDir = newDir;
        mNavigationTask = new NavigationTask(useCurrent, addToHistory, reload,
                searchInfo, scrollTo, mRestrictions, mChRooted);
        mNavigationTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, newDir);
    }

