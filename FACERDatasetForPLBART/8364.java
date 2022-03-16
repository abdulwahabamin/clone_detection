        @Override
        protected void onPostExecute(Boolean success) {
            SearchActivity activity = mActivity.get();
            if (activity == null) {
                return;
            }
            if (success) {
                // add to adapter
                activity.mAdapter.addNewItem(mHolder);
                int progress = activity.mAdapter.resultsSize();
                activity.toggleResults(progress > 0, false);
                String foundItems = activity.getResources().getQuantityString(
                        R.plurals.search_found_items, progress, progress);
                activity.mSearchFoundItems.setText(activity.getString(
                        R.string.search_found_items_in_directory,
                        foundItems, activity.mSearchDirectory));
            }
        }

