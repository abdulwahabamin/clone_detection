    public static void init(Context context , String logDir) {
        try {
            //开始监�?�外部存储的状�?
            ExternalStorage.getInstance().init(context);

            MLog.LogOptions options = new MLog.LogOptions();
            if (BuildConfig.DEBUG){
                options.logLevel = MLog.LogOptions.LEVEL_VERBOSE;
            } else {
                options.logLevel = MLog.LogOptions.LEVEL_INFO;
            }
            options.honorVerbose = false;
            options.logFileName = "logs.txt";
            MLog.initialize(logDir, options);
            MLog.info(TAG, "init MLog, logDir: %s fileName: %s level: %d", logDir, options.logFileName,
                    options.logLevel);
        }catch (Throwable t){
            t.printStackTrace();
        }
    }

