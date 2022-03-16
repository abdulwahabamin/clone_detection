    /**
     *
     * @param directory
     *            Where to put the logs folder. Should be a writable directory.
     * @return True for succeeded, false otherwise.
     */
    public static boolean initialize(String directory) {
        return LogToES.setLogPath(directory);
    }

