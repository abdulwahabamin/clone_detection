    /**
     * Returns the position of the specified item in the array.
     *
     * @param item The item to retrieve the position of.
     * @return The position of the specified item.
     */
    public int getPosition(FileSystemObject item) {
        int cc = getCount();
        for (int i = 0; i < cc; i++) {
            SearchResult sr = getItem(i).getSearchResult();
            if (sr.getFso().compareTo(item) == 0) {
                return i;
            }
        }
        return -1;
    }

