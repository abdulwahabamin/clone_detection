    /**
     * Method that returns the parent directory of a file/folder
     *
     * @param path The file/folder
     * @return String The parent directory
     */
    public static String getParentDir(File path) {
        String parent = path.getParent();
        if (parent == null && path.getAbsolutePath().compareTo(FileHelper.ROOT_DIRECTORY) != 0) {
            parent = FileHelper.ROOT_DIRECTORY;
        }
        return parent;
    }

