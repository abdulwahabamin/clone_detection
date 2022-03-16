    /**
     * Method that resolves the output path of the compressed file
     *
     * @return String The output path of the compressed file
     */
    private static String resolveOutputFile(CompressionMode mode, String src) {
        return String.format("%s.%s", src, mode.mExtension); //$NON-NLS-1$
    }

