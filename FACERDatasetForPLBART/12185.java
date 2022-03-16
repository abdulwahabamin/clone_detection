    /**
     * Returns if the passed directory is the current virtual storage directory
     *
     * @param directory The directory to check
     * @return boolean If is the current virtual storage directory
     */
    public static boolean isVirtualStorageDir(String directory) {
        return getVirtualStorageDir().equals(new File(directory));
    }

