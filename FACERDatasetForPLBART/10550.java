    /**
     * Method that returns if the folder if the root directory.
     *
     * @param folder The folder
     * @return boolean if the folder if the root directory
     */
    public static boolean isRootDirectory(String folder) {
        if (folder == null) return true;
        return isRootDirectory(new File(folder));
    }

