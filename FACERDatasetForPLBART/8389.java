    /**
     * Method that creates a {@link SearchInfoParcelable} reference from
     * the current data.
     *
     * @return SearchInfoParcelable The search info reference
     */
    private SearchInfoParcelable createSearchInfo() {
        SearchInfoParcelable parcel = new SearchInfoParcelable(
                mSearchDirectory,
                ((SearchResultAdapter)this.mSearchListView.getAdapter()).getData(),
                mQuery);
        return parcel;
    }

