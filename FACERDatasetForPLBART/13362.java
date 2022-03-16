    /**
     * Determines if a file system object complies w/ a user's display preferences implying that
     * the user is interested in this file
     * (sort mode, hidden files, ...).
     *
     * @param fso The file
     * @param restrictions The restrictions to apply when displaying files
     * @param chRooted If app run with no privileges
     * @return boolean indicating user's interest
     */
    public static boolean compliesWithDisplayPreferences(
            FileSystemObject fso, Map<DisplayRestrictions, Object> restrictions, boolean chRooted) {
        //Retrieve user preferences
        SharedPreferences prefs = Preferences.getSharedPreferences();
        FileManagerSettings showHiddenPref = FileManagerSettings.SETTINGS_SHOW_HIDDEN;
        FileManagerSettings showSystemPref = FileManagerSettings.SETTINGS_SHOW_SYSTEM;
        FileManagerSettings showSymlinksPref = FileManagerSettings.SETTINGS_SHOW_SYMLINKS;

        //Hidden files
        if (!prefs.getBoolean(
                showHiddenPref.getId(),
                ((Boolean)showHiddenPref.getDefaultValue()).booleanValue()) || chRooted) {
            if (fso.isHidden()) {
                return false;
            }
        }

        //System files
        if (!prefs.getBoolean(
                showSystemPref.getId(),
                ((Boolean)showSystemPref.getDefaultValue()).booleanValue()) || chRooted) {
            if (fso instanceof SystemFile) {
                return false;
            }
        }

        //Symlinks files
        if (!prefs.getBoolean(
                showSymlinksPref.getId(),
                ((Boolean)showSymlinksPref.getDefaultValue()).booleanValue()) || chRooted) {
            if (fso instanceof Symlink) {
                return false;
            }
        }

        // Restrictions (only apply to files)
        if (restrictions != null) {
            if (!isDirectory(fso)) {
                if (!isDisplayAllowed(fso, restrictions)) {
                    return false;
                }
            }
        }

        // all checks passed
        return true;
    }

