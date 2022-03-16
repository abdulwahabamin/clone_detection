    /**
     * Method that returns if the path is the real secure storage file
     *
     * @param path The path to check
     * @return boolean If the path is the secure storage
     */
    public static boolean isSecureStorageDir(TFile path) {
        return getSecureStorageRoot().equals(path);
    }

