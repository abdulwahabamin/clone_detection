    /**
     * Method that resolves the output path of the uncompressed file
     *
     * @return String The output path of the uncompressed file
     */
    private static String resolveOutputFile(String src) {
        String name = new File(FileHelper.getName(src)).getName();
        File dst = new File(new File(src).getParent(), name);
        return dst.getAbsolutePath();
    }

