    /**
     * 始化
     */
    public void init( Context context) {

        logger = Logger.getLogger(CrashHandler.class);
        mContext = context;

        // 获�?�系统默认的 UncaughtException 处�?�器  
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();

        // 设置该 CrashHandler 为程�?的默认处�?�器  
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

