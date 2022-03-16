    @Override
    public void onCreate() {
        super.onCreate();
        sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        localDataSource = LocalDataSource.getInstance(this);
        Fresco.initialize(this);
    }

