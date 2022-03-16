    /**
     * Method invoked when a execution ends.
     *
     * @param files The files obtains from the list
     * @param addToHistory If add path to history
     * @param isNewHistory If is new history
     * @param hasChanged If current directory was changed
     * @param searchInfo The search information (if calling activity is {@link "SearchActivity"})
     * @param newDir The new directory
     * @param scrollTo If not null, then listview must scroll to this item
     * @hide
     */
    void onPostExecuteTask(
            List<FileSystemObject> files, boolean addToHistory, boolean isNewHistory,
            boolean hasChanged, SearchInfoParcelable searchInfo,
            String newDir, final FileSystemObject scrollTo) {
        try {
            //Check that there is not errors and have some data
            if (files == null) {
                this.mCurrentDir = this.mPreviousDir;
                return;
            }

            //Remove parent directory if we are in the root of a chrooted environment
            if (this.mChRooted && StorageHelper.isStorageVolume(newDir)) {
                if (files.size() > 0 && files.get(0) instanceof ParentDirectory) {
                    files.remove(0);
                }
            }

            //Add to history?
            if (addToHistory && hasChanged && isNewHistory) {
                if (this.mOnHistoryListener != null) {
                    //Communicate the need of a history change
                    this.mOnHistoryListener.onNewHistory(onSaveState());
                }
            }

            //Load the data
            loadData(files);
            this.mFiles = files;
            if (searchInfo != null) {
                searchInfo.setSuccessNavigation(true);
            }

            //Change the breadcrumb
            if (this.mBreadcrumb != null) {
                this.mBreadcrumb.changeBreadcrumbPath(newDir, this.mChRooted);
            }

            //If scrollTo is null, the position will be set to 0
            scrollTo(scrollTo);

            //The current directory is now the "newDir"
            if (this.mOnDirectoryChangedListener != null) {
                FileSystemObject dir = FileHelper.createFileSystemObject(new File(newDir));
                this.mOnDirectoryChangedListener.onDirectoryChanged(dir);
            }

        } finally {
            //If calling activity is search, then save the search history
            if (searchInfo != null) {
                this.mOnHistoryListener.onNewHistory(searchInfo);
            }

            this.mPreviousDir = null;
            mNavigationTask = null;

            //End of loading data
            try {
                NavigationView.this.mBreadcrumb.endLoading();
            } catch (Throwable ex) {
                /**NON BLOCK**/
            }
        }
    }

