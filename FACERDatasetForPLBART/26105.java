    public static String getLogTrace() {

        File logDir = new File(sdcardRoot() + File.separator + mAppName + File.separator+"log");
        if(!logDir.exists()) {
            makeDir(logDir);
        }
        return logDir.getPath();
    }

