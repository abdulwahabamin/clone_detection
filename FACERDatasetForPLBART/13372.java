    /**
     * Method that converts an absolute path to a relative path
     *
     * @param path The absolute path to convert
     * @param relativeTo The absolute path from which make path relative to (a folder)
     * @return String The relative path
     */
    public static String toRelativePath(String path, String relativeTo) {
        // Normalize the paths
        File f1 = new File(path);
        File f2 = new File(relativeTo);
        String s1 = f1.getAbsolutePath();
        String s2 = f2.getAbsolutePath();
        if (!s2.endsWith(File.separator)) {
            s2 = s2 + File.separator;
        }

        // If s2 contains s1 then the relative is replace of the start of the path
        if (s1.startsWith(s2)) {
            return s1.substring(s2.length());
        }

        StringBuffer relative = new StringBuffer();
        do {
            File f3 = new File(s2);
            relative.append(String.format("..%s", File.separator)); //$NON-NLS-1$
            s2 = f3.getParent() + File.separator;
        } while (!s1.startsWith(s2) && !s1.startsWith(new File(s2).getAbsolutePath()));
        s2 = new File(s2).getAbsolutePath();
        return relative.toString() + s1.substring(s2.length());
    }

