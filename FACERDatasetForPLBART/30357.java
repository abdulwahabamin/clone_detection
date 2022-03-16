    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //在主线程中new的handler就是主线程的handler
        //�?始化Handler
        HeConfig.init(ContentUtil.APK_USERNAME, ContentUtil.APK_KEY);
        HeConfig.switchToFreeServerNode();
        configLog();

    }

