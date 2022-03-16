    public synchronized static ReverseGeocodingCacheDbHelper getInstance(Context ctx) {
        if (instance == null) {
            instance = new ReverseGeocodingCacheDbHelper(ctx.getApplicationContext());
        }
        return instance;
    }

