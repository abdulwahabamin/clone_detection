    /**
     * Method that resolves the identifier to use as command
     *
     * @param src The compressed file
     * @return String The identifier of the command
     */
    private static String resolveId(String src) {
        Mode mode = getMode(src);
        if (mode != null) {
            return mode.mId;
        }
        return ""; //$NON-NLS-1$
    }

