    @Override
    public String getString(int column) {
        if (column == mAuthorityIndex) {
            return mAuthority;
        } else if (column == mRootIdIndex) {
            return mRootId;
        } else {
            return mCursor.getString(column);
        }
    }

