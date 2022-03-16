    /**
     * Method that do a comparison between 2 file system objects.
     *
     * @param fso1 The first file system objects
     * @param fso2 The second file system objects
     * @param mode The sort mode
     * @return int a negative integer if {@code fso1} is less than {@code fso2};
     *         a positive integer if {@code fso1} is greater than {@code fso2};
     *         0 if {@code fso1} has the same order as {@code fso2}.
     */
    public static int doCompare(
            final FileSystemObject fso1,
            final FileSystemObject fso2,
            final NavigationSortMode mode) {

        // Retrieve the user preference for case sensitive sort
        boolean caseSensitive =
                Preferences.getSharedPreferences().
                    getBoolean(
                        FileManagerSettings.SETTINGS_CASE_SENSITIVE_SORT.getId(),
                        ((Boolean)FileManagerSettings.SETTINGS_CASE_SENSITIVE_SORT.
                                getDefaultValue()).booleanValue());

        //Name (ascending)
        if (mode.getId() == NavigationSortMode.NAME_ASC.getId()) {
            if (!caseSensitive) {
                return fso1.getName().compareToIgnoreCase(fso2.getName());
            }
            return fso1.getName().compareTo(fso2.getName());
        }
        //Name (descending)
        if (mode.getId() == NavigationSortMode.NAME_DESC.getId()) {
            if (!caseSensitive) {
                return fso1.getName().compareToIgnoreCase(fso2.getName()) * -1;
            }
            return fso1.getName().compareTo(fso2.getName()) * -1;
        }

        //Date (ascending)
        if (mode.getId() == NavigationSortMode.DATE_ASC.getId()) {
            return fso1.getLastModifiedTime().compareTo(fso2.getLastModifiedTime());
        }
        //Date (descending)
        if (mode.getId() == NavigationSortMode.DATE_DESC.getId()) {
            return fso1.getLastModifiedTime().compareTo(fso2.getLastModifiedTime()) * -1;
        }

        //Size (ascending)
        if (mode.getId() == NavigationSortMode.SIZE_ASC.getId()) {
            return Long.compare(fso1.getSize(), fso2.getSize());
        }
        //Size (descending)
        if (mode.getId() == NavigationSortMode.SIZE_DESC.getId()) {
            return Long.compare(fso1.getSize(), fso2.getSize()) * -1;
        }

        //Type (ascending)
        if (mode.getId() == NavigationSortMode.TYPE_ASC.getId()) {
            // Shouldn't need context here, mimetypes should be loaded
            return MimeTypeHelper.compareFSO(null, fso1, fso2);
        }
        //Type (descending)
        if (mode.getId() == NavigationSortMode.TYPE_DESC.getId()) {
            // Shouldn't need context here, mimetypes should be loaded
            return MimeTypeHelper.compareFSO(null, fso1, fso2) * -1;
        }

        //Comparison between files directly
        return fso1.compareTo(fso2);
    }

