    public synchronized static LocationsFileDbHelper getInstance(Context ctx) {
        if (instance == null) {
            instance = new LocationsFileDbHelper(ctx.getApplicationContext());
        }
        return instance;
    }

