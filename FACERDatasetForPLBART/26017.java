    /**
     * Get log output paths.
     * @return null if not ready.
     */
    public static LogOutputPaths getLogOutputPaths() {
        LogOutputPaths ret = new LogOutputPaths();
        if (!getLogOutputPaths(ret)) {

            MLog.error("MLog", "failed to get log output paths.");
        }
        return ret;
    }

