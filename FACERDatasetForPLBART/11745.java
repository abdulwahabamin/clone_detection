    /**
     * Method that resolves the arguments for the archive mode
     *
     * @return String[] The arguments
     */
    private final static String[] resolveArchiveArgs(Mode mode, String dst) {
        if (mode.compareTo(Mode.A_ZIP) == 0) {
            return new String[]{
                    FileHelper.getParentDir(dst),
                    dst
                };
        }
        return new String[]{
                FileHelper.getParentDir(dst),
                mode.mFlag,
                dst
            };
    }

