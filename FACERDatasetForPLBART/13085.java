    /**
     * Method that refresh the view data.
     *
     * @param scrollTo Scroll to object
     */
    public void refresh(FileSystemObject scrollTo) {
        //Check that current directory was set
        if (this.mCurrentDir == null || this.mFiles == null) {
            return;
        }

        boolean addToHistory = false;
        boolean reload = true;
        boolean useCurrent = false;
        SearchInfoParcelable searchInfo = null;

        String newDir = this.mCurrentDir;
        if (this.mNavigationTask != null) {
            addToHistory = this.mNavigationTask.mAddToHistory;
            reload = this.mNavigationTask.mReload;
            useCurrent = this.mNavigationTask.mUseCurrent;
            searchInfo = this.mNavigationTask.mSearchInfo;
            this.mNavigationTask.cancel(true);
            this.mNavigationTask = null;
            this.mCurrentDir = this.mPreviousDir;
            this.mPreviousDir = null;
        }
        //Reload data
        changeCurrentDir(newDir, addToHistory, reload, useCurrent, searchInfo, scrollTo);
    }

