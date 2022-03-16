        /**
         * {@inheritDoc}
         */
        @Override
        protected List<FileSystemObject> doInBackground(String... params) {
            // Check navigation security (don't allow to go outside the ChRooted environment if one
            // is created)
            mNewDirChecked = checkChRootedNavigation(params[0]);

            mHasChanged = !(NavigationView.this.mPreviousDir != null &&
                    NavigationView.this.mPreviousDir.compareTo(mNewDirChecked) == 0);
            mIsNewHistory = (NavigationView.this.mPreviousDir != null);

            try {
                //Reset the custom title view and returns to breadcrumb
                if (NavigationView.this.mTitle != null) {
                    NavigationView.this.mTitle.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                NavigationView.this.mTitle.restoreView();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }


                //Start of loading data
                if (NavigationView.this.mBreadcrumb != null) {
                    try {
                        NavigationView.this.mBreadcrumb.startLoading();
                    } catch (Throwable ex) {
                        /**NON BLOCK**/
                    }
                }

                //Get the files, resolve links and apply configuration
                //(sort, hidden, ...)
                List<FileSystemObject> files = NavigationView.this.mFiles;
                if (!mUseCurrent) {
                    files = CommandHelper.listFiles(getContext(), mNewDirChecked, null);
                }

                //Apply user preferences
                List<FileSystemObject> sortedFiles =
                        FileHelper.applyUserPreferences(files, this.mRestrictions, this.mChRooted);

                return sortedFiles;

            } catch (final ConsoleAllocException e) {
                //Show exception and exists
                NavigationView.this.post(new Runnable() {
                    @Override

