    /**
     * Method that parses and extracts the permissions from a unix string format.
     *
     * @param rawPermissions The raw permissions
     * @return Permissions An object with all the permissions
     * @throws ParseException If the permissions can't be parsed
     * @see ParseHelper#parsePermission(String)
     */
    public static Permissions fromRawString(String rawPermissions) throws ParseException {
        return ParseHelper.parsePermission(rawPermissions);
    }

