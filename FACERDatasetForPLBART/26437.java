    public static void initialize(Application context) {
        initANRWatch(context);
        initCrashReport(context);
        initFile();
        initLog(context);
        initSharedPreference(context);
        workThreadInit(context);
    }

