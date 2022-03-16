    /**
     * Method that returns the unix string representation of the type and permissions of the
     * file system object.
     *
     * @return String The string representation
     */
    public String toRawPermissionString() {
        return Character.toString(getUnixIdentifier())
                + getPermissions().toRawString();
    }

