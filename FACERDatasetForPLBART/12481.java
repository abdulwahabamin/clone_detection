    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // - 0
        dest.writeInt(this.mId);
        // - 1
        dest.writeInt(this.mCurrentDir == null ? 0 : 1);
        if (this.mCurrentDir != null) {
            dest.writeString(this.mCurrentDir);
        }
        // - 2
        dest.writeInt(this.mChRooted ? 1 : 0);
        // - 3
        dest.writeInt(this.mSelectedFiles == null ? 0 : 1);
        if (this.mSelectedFiles != null) {
            dest.writeList(this.mSelectedFiles);
        }
        // - 4
        dest.writeInt(this.mFiles == null ? 0 : 1);
        if (this.mFiles != null) {
            dest.writeList(this.mFiles);
        }

        // - 5
        dest.writeInt(this.mFirstVisible == null ? 0 : 1);
        if (this.mFirstVisible != null) {
            dest.writeSerializable(mFirstVisible);
        }
    }

