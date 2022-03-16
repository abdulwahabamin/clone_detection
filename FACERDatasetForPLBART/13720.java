    /**
     * Gets the file size of specific directory/file
     *
     * @param f
     * @return size of file/directory in bytes
     */
    private long getFolderSize(File f) {
        long size = 0;
        if (f.isDirectory()) {
            for (File file : f.listFiles()) {
                size += getFolderSize(file);
            }
        } else {
            size = f.length();
        }
        return size;
    }

