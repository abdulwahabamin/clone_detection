    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //- 0
        dest.writeInt(this.mNavigationViews.length);
        int cc = this.mNavigationViews.length;
        for (int i = 0; i < cc; i++) {
            dest.writeParcelable(this.mNavigationViews[i], 0);
        }
        //- 1
        dest.writeInt(this.mHistoryInfo == null ? 0 : this.mHistoryInfo.size());
        if (this.mHistoryInfo != null) {
            dest.writeList(this.mHistoryInfo);
        }
    }

