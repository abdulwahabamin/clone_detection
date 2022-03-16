    public static boolean setLogPath(String logDir) {
        if (logDir == null || logDir.length() == 0) {
            return false;
        }
        mLogPath = logDir;

        new File(logDir).mkdirs();

        return new File(logDir).isDirectory();
    }

