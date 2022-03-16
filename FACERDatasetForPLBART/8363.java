        @Override
        protected Boolean doInBackground(FileSystemObject... params) {
            SearchActivity activity = mActivity.get();
            if (activity == null) {
                return false;
            }

            FileSystemObject result = params[0];
            // check against user's display preferences
            if ( !FileHelper.compliesWithDisplayPreferences(result, null, activity.mChRooted) ) {
                return false;
            }

            // resolve sym links
            FileHelper.resolveSymlink(activity, result);

            // convert to search result
            mResult = SearchHelper.convertToResult(result, activity.mQuery);

            mHolder = activity.generateDataHolder(mResult);

            return mHolder != null && mResult != null;
        }

