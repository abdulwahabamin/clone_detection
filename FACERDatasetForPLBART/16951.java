    private static void enableDisableDebugMode(boolean enable) {
        if (enable) {
            FireLog.isVerboseLogOn = true;
            FireLog.isDebugLogOn = true;
            FireLog.isInfoLogOn = true;
        } else {
            FireLog.isVerboseLogOn = false;
            FireLog.isDebugLogOn = false;
            FireLog.isInfoLogOn = false;
        }
    }

