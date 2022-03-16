    private LocationsDbHelper(Context context) {
        super(context, null, null, DATABASE_VERSION);
        this.context = context;
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(SQL_CREATE_TABLE_LOCATIONS);
        List<Location> locations = LocationsFileDbHelper.getInstance(context).getAllRows();
        for (Location location: locations) {
            createLocation(location);
        }
    }

