    /**
     * Method that checks if the source file passed belongs to (is under) the directory passed
     *
     * @param src The file to check
     * @param dir The parent file to check
     * @return boolean If the source belongs to the directory
     */
    public static boolean belongsToDirectory(File src, File dir) {
        if (dir.isFile()) {
            return false;
        }
        return src.getAbsolutePath().startsWith(dir.getAbsolutePath());
    }

