    @Override
    public void onCreate() {
        super.onCreate();

        Preferences.init(this);
        ScreenUtils.init(this);
        Bmob.initialize(this, BuildConfig.BMOB_KEY);
        LocationManager.get().init(this);
    }

