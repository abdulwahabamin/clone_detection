    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        AppUtils.init(this);
        KLog.init(true,"Rair");
    }

