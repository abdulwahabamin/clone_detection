    /**
     * Method that list all the virtual directories
     *
     * @return List<Directory> The list of virtual directories
     */
    public static List<Directory> getVirtualMountableDirectories() {
        final Date date = new Date(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        List<Directory> directories = new ArrayList<Directory>();
        for (VirtualMountPointConsole console : sVirtualConsoles) {
            File dir = null;
            do {
                dir = console.getVirtualMountPoint();
            } while (dir.getParentFile() != null && !isVirtualStorageDir(dir.getParent()));

            if (dir != null) {
                Directory directory = new Directory(
                        dir.getName(),
                        getVirtualStorageDir().getAbsolutePath(),
                        sVirtualIdentity.getUser(),
                        sVirtualIdentity.getGroup(),
                        sVirtualFolderPermissions,
                        date, date, date);
                directory.setSecure(console.isSecure());
                directory.setRemote(console.isRemote());

                if (!directories.contains(directory)) {
                    directories.add(directory);
                }
            }
        }
        return directories;
    }

