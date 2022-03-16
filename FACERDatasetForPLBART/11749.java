    /**
     * Method that converts the absolute paths of the source files to relative paths
     *
     * @param dst The destination compressed file
     * @param src The source uncompressed files
     * @return String[] The array of relative paths
     */
    private static String[] convertAbsolutePathsToRelativePaths(String dst, String[] src) {
        File parent  = new File(dst).getParentFile();
        String p = File.separator;
        if (parent != null) {
            p = parent.getAbsolutePath();
        }

        // Converts every path
        String[] out = new String[src.length];
        int cc = src.length;
        for (int i = 0; i < cc; i++) {
            out[i] = FileHelper.toRelativePath(src[i], p);
        }
        return out;
    }

