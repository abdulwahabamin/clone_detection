    /**
     * Method that ensures that the actual console has access to read the
     * {@link FileSystemObject} passed.
     *
     * @param console The console
     * @param fso The {@link FileSystemObject} to check
     * @param executable The executable to associate to the {@link InsufficientPermissionsException}
     * @throws InsufficientPermissionsException If the console doesn't have enough rights
     */
    public static void ensureReadAccess(
            Console console, FileSystemObject fso, SyncResultExecutable executable)
            throws InsufficientPermissionsException {
        try {
            if (console.isPrivileged()) {
                // Should have access
                return;
            }
            if (console instanceof JavaConsole &&
                    StorageHelper.isPathInStorageVolume(fso.getFullPath())) {
                // Java console runs in chrooted environment, and sdcard are always readable
                return;
            }
            Identity identity = console.getIdentity();
            if (identity == null) {
                throw new InsufficientPermissionsException(executable);
            }
            Permissions permissions = fso.getPermissions();
            User user = fso.getUser();
            Group group = fso.getGroup();
            List<Group> groups = identity.getGroups();
            if ( permissions == null || user == null || group == null) {
                throw new InsufficientPermissionsException(executable);
            }
            // Check others
            if (permissions.getOthers().isRead()) {
                return;
            }
            // Check user
            if (user.getId() == identity.getUser().getId() && permissions.getUser().isRead()) {
                return;
            }
            // Check group
            if (group.getId() == identity.getGroup().getId() && permissions.getGroup().isRead()) {
                return;
            }
            // Check groups
            int cc = groups.size();
            for (int i = 0; i < cc; i++) {
                Group g = groups.get(i);
                if (group.getId() == g.getId() && permissions.getGroup().isRead()) {
                    return;
                }
            }

        } catch (Exception e) {
            Log.e(TAG, "Failed to check fso read permission,", e); //$NON-NLS-1$
        }
        throw new InsufficientPermissionsException(executable);
    }

