    /**
     * Fill the object from the parcel information.
     *
     * @param in The parcel information to recreate the object
     */
    private void readFromParcel(Parcel in) {
        //- 0
        int hasSearchDirectory = in.readInt();
        if (hasSearchDirectory == 1) {
            this.mSearchDirectory = in.readString();
        }
        //- 1
        int hasSearchResultList = in.readInt();
        if (hasSearchResultList == 1) {
            List<SearchResult> searchResultList = new ArrayList<SearchResult>();
            in.readList(searchResultList, SearchInfoParcelable.class.getClassLoader());
            this.mSearchResultList = new ArrayList<SearchResult>(searchResultList);
        }
        //- 2
        int hasSearchQuery = in.readInt();
        if (hasSearchQuery == 1) {
            this.mSearchQuery = (Query)in.readParcelable(
                    SearchInfoParcelable.class.getClassLoader());
        }
        setTitle();
        //- 3
        this.mSuccessNavigation = in.readInt() != 1;
    }

