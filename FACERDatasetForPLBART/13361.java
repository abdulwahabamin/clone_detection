    /**
     * Method that applies the configuration modes to the listed files
     * (sort mode, hidden files, ...).
     *
     * @param files The listed files
     * @param restrictions The restrictions to apply when displaying files
     * @param noSort If sort must be applied
     * @param chRooted If app run with no privileges
     * @return List<FileSystemObject> The applied mode listed files
     */
    public static List<FileSystemObject> applyUserPreferences(
            List<FileSystemObject> files, Map<DisplayRestrictions, Object> restrictions,
            boolean noSort, boolean chRooted) {
        //Retrieve user preferences
        SharedPreferences prefs = Preferences.getSharedPreferences();
        FileManagerSettings sortModePref = FileManagerSettings.SETTINGS_SORT_MODE;
        FileManagerSettings showDirsFirstPref = FileManagerSettings.SETTINGS_SHOW_DIRS_FIRST;
        FileManagerSettings showHiddenPref = FileManagerSettings.SETTINGS_SHOW_HIDDEN;
        FileManagerSettings showSystemPref = FileManagerSettings.SETTINGS_SHOW_SYSTEM;
        FileManagerSettings showSymlinksPref = FileManagerSettings.SETTINGS_SHOW_SYMLINKS;

        //Remove all unnecessary files (no required by the user)
        int cc = files.size();
        for (int i = cc - 1; i >= 0; i--) {
            FileSystemObject file = files.get(i);

            //Hidden files
            if (!prefs.getBoolean(
                    showHiddenPref.getId(),
                    ((Boolean)showHiddenPref.getDefaultValue()).booleanValue()) || chRooted) {
                if (file.isHidden()) {
                    files.remove(i);
                    continue;
                }
            }

            //System files
            if (!prefs.getBoolean(
                    showSystemPref.getId(),
                    ((Boolean)showSystemPref.getDefaultValue()).booleanValue()) || chRooted) {
                if (file instanceof SystemFile) {
                    files.remove(i);
                    continue;
                }
            }

            //Symlinks files
            if (!prefs.getBoolean(
                    showSymlinksPref.getId(),
                    ((Boolean)showSymlinksPref.getDefaultValue()).booleanValue()) || chRooted) {
                if (file instanceof Symlink) {
                    files.remove(i);
                    continue;
                }
            }

            // Restrictions (only apply to files)
            if (restrictions != null) {
                if (!isDirectory(file)) {
                    if (!isDisplayAllowed(file, restrictions)) {
                        files.remove(i);
                        continue;
                    }
                }
            }
        }

        //Apply sort mode
        if (!noSort) {
            final boolean showDirsFirst =
                    prefs.getBoolean(
                            showDirsFirstPref.getId(),
                        ((Boolean)showDirsFirstPref.getDefaultValue()).booleanValue());
            final NavigationSortMode sortMode =
                    NavigationSortMode.fromId(
                            prefs.getInt(sortModePref.getId(),
                            ((ObjectIdentifier)sortModePref.getDefaultValue()).getId()));
            Collections.sort(files, new Comparator<FileSystemObject>() {
                @Override
                public int compare(FileSystemObject lhs, FileSystemObject rhs) {
                    //Parent directory always goes first
                    boolean isLhsParentDirectory = lhs instanceof ParentDirectory;
                    boolean isRhsParentDirectory = rhs instanceof ParentDirectory;
                    if (isLhsParentDirectory || isRhsParentDirectory) {
                        if (isLhsParentDirectory && isRhsParentDirectory) {
                            return 0;
                        }
                        return (isLhsParentDirectory) ? -1 : 1;
                    }

                    //Need to sort directory first?
                    if (showDirsFirst) {
                        boolean isLhsDirectory = FileHelper.isDirectory(lhs);
                        boolean isRhsDirectory = FileHelper.isDirectory(rhs);
                        if (isLhsDirectory || isRhsDirectory) {
                            if (isLhsDirectory && isRhsDirectory) {
                                //Apply sort mode
                                return FileHelper.doCompare(lhs, rhs, sortMode);
                            }
                            return (isLhsDirectory) ? -1 : 1;
                        }
                    }

                    //Apply sort mode
                    return FileHelper.doCompare(lhs, rhs, sortMode);
                }

            });
        }

        //Return the files
        return files;
    }

