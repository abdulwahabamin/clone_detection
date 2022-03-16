        @Override
        protected void onPostExecute(List<DataHolder> results) {
            if (!isResumed()) {
                return;
            }
            mAdapterList.clear();
            mAdapterList.addAll(results);
            mAdapter.notifyDataSetChanged();

            String foundItems = getResources().getQuantityString(R.plurals.search_found_items,
                    results.size(), results.size());
            mSearchFoundItems.setText(String.format(mSearchFoundString,
                    foundItems, mSearchDirectory));

        }

