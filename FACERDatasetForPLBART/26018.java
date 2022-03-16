    /**
     * Get log output paths.
     * @param out  Output destination.
     * @return True for success, false otherwise.
     */
    public static boolean getLogOutputPaths(LogOutputPaths out) {
        return LogToES.getLogOutputPaths(out, sOptions.logFileName);
    }

