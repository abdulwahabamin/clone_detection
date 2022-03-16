    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //- 0
        dest.writeInt(this.mSearchDirectory == null ? 0 : 1);
        if (this.mSearchDirectory != null) {
            dest.writeString(this.mSearchDirectory);
        }
        //- 1
        dest.writeInt(this.mSearchResultList == null ? 0 : 1);
        if (this.mSearchResultList != null) {
            dest.writeList(this.mSearchResultList);
        }
        //- 2
        dest.writeInt(this.mSearchQuery == null ? 0 : 1);
        if (this.mSearchQuery != null) {
            dest.writeParcelable(this.mSearchQuery, 0);
        }
        //- 3
        dest.writeInt(this.mSuccessNavigation ? 1 : 0);
    }

