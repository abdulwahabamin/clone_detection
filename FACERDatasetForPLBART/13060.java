        /**
         * {@inheritDoc}
         */
        @Override
        protected void onPostExecute(List<FileSystemObject> files) {
            // This means an exception. This method will be recalled then
            onPostExecuteTask(files, mAddToHistory, mIsNewHistory, mHasChanged,
                        mSearchInfo, mNewDirChecked, mScrollTo);

            // Do animation
            fadeEfect(false);
        }

