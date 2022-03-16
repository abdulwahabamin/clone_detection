    /**
     * Method that display the number of found items.
     *
     * @param items The number of items
     * @param searchDirectory The search directory path
     * @hide
     */
    void setFoundItems(final int items, final String searchDirectory) {
        if (this.mSearchFoundItems != null) {
            this.mSearchFoundItems.post(new Runnable() {
                @Override
                public void run() {
                    String directory = searchDirectory;
                    if (SearchActivity.this.mChRooted &&
                            directory != null && directory.length() > 0) {
                        directory = StorageHelper.getChrootedPath(directory);
                    }

                    String foundItems =
                            getResources().
                                getQuantityString(
                                    R.plurals.search_found_items, items, Integer.valueOf(items));
                    SearchActivity.this.mSearchFoundItems.setText(String.format(mSearchFoundString,
                            foundItems, directory));
                }
            });
        }
    }

