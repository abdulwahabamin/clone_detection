    /**
     * Method that returns a more human readable of the size
     * of a file system object.
     *
     * @param fso File system object
     * @return String The human readable size (void if fso don't supports size)
     */
    public static String getHumanReadableSize(FileSystemObject fso) {
        //Only if has size
        if (fso instanceof Directory) {
            return ""; //$NON-NLS-1$
        }
        if (hasSymlinkRef(fso)) {
            if (isSymlinkRefDirectory(fso)) {
                return ""; //$NON-NLS-1$
            }
            return getHumanReadableSize(((Symlink)fso).getLinkRef().getSize());
        }
        return getHumanReadableSize(fso.getSize());
    }

