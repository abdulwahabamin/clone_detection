    /**
     * Method that applies the configuration modes to the listed files
     * (sort mode, hidden files, ...).
     *
     * @param files The listed files
     * @param restrictions The restrictions to apply when displaying files
     * @param chRooted If app run with no privileges
     * @return List<FileSystemObject> The applied mode listed files
     */
    public static List<FileSystemObject> applyUserPreferences(
                    List<FileSystemObject> files, Map<DisplayRestrictions,
                    Object> restrictions, boolean chRooted) {
        return applyUserPreferences(files, restrictions, false, chRooted);
    }

