    /**
     * Method that checks if both path are the same (by checking sensitive cases).
     *
     * @param src The source path
     * @param dst The destination path
     * @return boolean If both are the same path
     */
    public static boolean isSamePath(String src, String dst) {
        // This is only true if both are exactly the same path or the same file in insensitive
        // file systems
        File o1 = new File(src);
        File o2 = new File(dst);
        return o1.equals(o2);
    }

