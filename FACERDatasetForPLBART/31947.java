    public synchronized static LocationsDbHelper getInstance(Context ctx) {
        if (instance == null) {
            instance = new LocationsDbHelper(ctx.getApplicationContext());
        }
        return instance;
    }

