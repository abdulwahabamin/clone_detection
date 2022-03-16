    /**
     * Method that creates a {@link FileSystemObject} from a {@link File}
     *
     * @param file The file or folder reference
     * @return FileSystemObject The file system object reference
     */
    public static FileSystemObject createFileSystemObject(File file) {
        try {
            // The user and group name of the files. Use the defaults one for sdcards
            final String USER = "root"; //$NON-NLS-1$
            final String GROUP = "sdcard_r"; //$NON-NLS-1$

            // The user and group name of the files. In ChRoot, aosp give restrict access to
            // this user and group. This applies for permission also. This has no really much
            // interest if we not allow to change the permissions
            AID userAID = AIDHelper.getAIDFromName(USER);
            AID groupAID = AIDHelper.getAIDFromName(GROUP);
            User user = new User(userAID.getId(), userAID.getName());
            Group group = new Group(groupAID.getId(), groupAID.getName());
            Permissions perm = file.isDirectory()
                    ? Permissions.createDefaultFolderPermissions()
                    : Permissions.createDefaultFilePermissions();

            // Build a directory?
            Date lastModified = new Date(file.lastModified());
            if (file.isDirectory()) {
                return
                    new Directory(
                            file.getName(),
                            file.getParent(),
                            user, group, perm,
                            lastModified, lastModified, lastModified); // The only date we have
            }

            // Build a regular file
            return
                new RegularFile(
                        file.getName(),
                        file.getParent(),
                        user, group, perm,
                        file.length(),
                        lastModified, lastModified, lastModified); // The only date we have
        } catch (Exception e) {
            Log.e(TAG, "Exception retrieving the fso", e); //$NON-NLS-1$
        }
        return null;
    }

