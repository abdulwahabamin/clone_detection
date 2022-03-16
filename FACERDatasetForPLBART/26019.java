    /**
     *
     * @param directory
     *            Where to put the logs folder.
     * @param options
     *            null-ok. Options for log methods.
     * @return True for succeeded, false otherwise.
     */
    public static boolean initialize(String directory, LogOptions options) {
        setOptions(options);
        return LogToES.setLogPath(directory);
    }

