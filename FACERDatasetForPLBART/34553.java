    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        weatherDatabaseHelper = new WeatherDatabaseHelper(this,"weather",null,1);
    }

