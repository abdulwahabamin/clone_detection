    /**
     * Method that returns if the folder if the root directory.
     *
     * @param folder The folder
     * @return boolean if the folder if the root directory
     */
    public static boolean isRootDirectory(File folder) {
        if (folder.getPath() == null) return true;
        return folder.getPath().compareTo(FileHelper.ROOT_DIRECTORY) == 0;
    }

