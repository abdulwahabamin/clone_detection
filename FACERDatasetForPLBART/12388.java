    /**
     * Method that returns a string representation of the permissions
     * conforming with the unix style (rwx).
     *
     * @return String The string representation of the permissions
     */
    public String toRawString() {
        if (mRawString == null) {
            mRawString = getRawString();
        }
        return mRawString;
    }

