    /**
     * Method that returns the canonical/absolute path of the path.<br/>
     * This method performs path resolution
     *
     * @param path The path to convert
     * @return String The canonical/absolute path
     */
    public static String getAbsPath(String path) {
        try {
            return new File(path).getCanonicalPath();
        } catch (Exception e) {
            return new File(path).getAbsolutePath();
        }
    }

