    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance(this.getApplicationContext()).init();
        initLeakCheck();
        initLogUtil();
    }

