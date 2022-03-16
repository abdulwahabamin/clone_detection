    /**
     * Method that resolves the arguments for the compression mode
     *
     * @return String[] The arguments
     */
    private static String[] resolveCompressArgs(CompressionMode mode, String src) {
        switch (mode) {
            case C_GZIP:
            case C_BZIP:
                return new String[]{src};
            default:
                return new String[]{};
        }
    }

