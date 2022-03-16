    /**
     * Method that loads all virtual mount points.
     *
     * @return List<Bookmark> The bookmarks loaded
     */
    private List<Bookmark> loadVirtualBookmarks() {
        // Initialize the bookmarks
        List<Bookmark> bookmarks = new ArrayList<Bookmark>();
        List<MountPoint> mps = VirtualMountPointConsole.getVirtualMountPoints();
        for (MountPoint mp : mps) {
            BOOKMARK_TYPE type = null;
            String name = null;
            if (mp.isSecure()) {
                type = BOOKMARK_TYPE.SECURE;
                name = getString(R.string.bookmarks_secure);
            } else if (mp.isRemote()) {
                type = BOOKMARK_TYPE.REMOTE;
                name = getString(R.string.bookmarks_remote);
            } else {
                continue;
            }
            bookmarks.add(new Bookmark(type, name, mp.getMountPoint()));
        }
        return bookmarks;
    }

