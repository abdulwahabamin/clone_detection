    public synchronized static CurrentWeatherDbHelper getInstance(Context ctx) {
        if (instance == null) {
            instance = new CurrentWeatherDbHelper(ctx.getApplicationContext());
        }
        return instance;
    }

