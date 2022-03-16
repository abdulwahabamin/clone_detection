    /**
     * Method that returns a string representation of the permissions,
     * conforming with the unix style (rwx).
     *
     * @return String The string representation of the permissions
     */
    public String toRawString() {
        return this.mUser.toRawString()
                + this.mGroup.toRawString()
                + this.mOthers.toRawString();
    }

