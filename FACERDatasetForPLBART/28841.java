    public WeatherPagerAdapter(Context context, FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
        this.mContext = context;
        this.database = PFASQLiteHelper.getInstance(context);
        this.cities = database.getAllCitiesToWatch();
        this.currentWeathers = database.getAllCurrentWeathers();
        this.prefManager = new PrefManager(context);
    }

