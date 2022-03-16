    /**
     * Method that add to the path the trailing slash
     *
     * @param path The path
     * @return String The path with the trailing slash
     */
    public static String addTrailingSlash(String path) {
        if (path == null) return null;
        return path.endsWith(File.separator) ? path : path + File.separator;
    }

