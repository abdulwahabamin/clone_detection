    /**
     * Method that returns the associated icon to the bookmark.
     *
     * @param bookmark The bookmark
     * @return String The associated icon resource name
     */
    public static String getIcon(Bookmark bookmark) {
        if (bookmark.mType.compareTo(Bookmark.BOOKMARK_TYPE.HOME) == 0) {
            return "ic_home_drawable"; //$NON-NLS-1$
        }
        if (bookmark.mType.compareTo(Bookmark.BOOKMARK_TYPE.FILESYSTEM) == 0) {
            return "ic_filesystem_drawable"; //$NON-NLS-1$
        }
        if (bookmark.mType.compareTo(Bookmark.BOOKMARK_TYPE.SDCARD) == 0) {
            return "ic_sdcard_drawable"; //$NON-NLS-1$
        }
        if (bookmark.mType.compareTo(Bookmark.BOOKMARK_TYPE.USB) == 0) {
            return "ic_usb_drawable"; //$NON-NLS-1$
        }
        if (bookmark.mType.compareTo(Bookmark.BOOKMARK_TYPE.SECURE) == 0) {
            return "ic_secure_drawable"; //$NON-NLS-1$
        }
        if (bookmark.mType.compareTo(Bookmark.BOOKMARK_TYPE.REMOTE) == 0) {
            return "ic_remote_drawable"; //$NON-NLS-1$
        }
        //Bookmark add by the user
        return "ic_user_defined_bookmark_drawable"; //$NON-NLS-1$
    }

