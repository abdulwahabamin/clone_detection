    private void initLogUtil() {
        if (BuildConfig.DEBUG) {
            LogUtil.mLogOn = true;
            LogUtil.mLogLevel = LogUtil.VERBOSE;
        } else {
            LogUtil.mLogOn = false;
        }
    }

