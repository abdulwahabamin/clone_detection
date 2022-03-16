    public synchronized static WeatherForecastDbHelper getInstance(Context ctx) {
        if (instance == null) {
            instance = new WeatherForecastDbHelper(ctx.getApplicationContext());
        }
        return instance;
    }

