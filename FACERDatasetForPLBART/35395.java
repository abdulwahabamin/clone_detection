    @Override
    public void onCreate() {
        super.onCreate();
        mcontext = this;
        new Thread(new Runnable() {
            @Override
            public void run() {
                NetService.getInstance().init(cityUrl);
                Logger.addLogAdapter(new AndroidLogAdapter());
            }
        }).start();

//        Stetho.initializeWithDefaults(this);
//        mRefWatcher = LeakCanary.install(mcontext);
        TimeMonitorManager.getInstance().getTimeMonitor(TimeMonitorConfig
                .TIME_MONITOR_ID_APPLICATION_START).recordingTimeTag("ApplicationCreated");

//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getAppContext(),
//                "weather-db", null);
//        daoMaster = new DaoMaster(helper.getWritableDatabase());


//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.init(this);
//        crashHandler.sendPreviousReportsToServer();
    }

