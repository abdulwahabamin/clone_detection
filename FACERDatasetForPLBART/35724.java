    /**
     * �?�例获�?�OpenHelper实例
     *
     * @param context application context
     * @return instance
     */
    public static CityDatabaseHelper getInstance(Context context) {

        context = context.getApplicationContext();
        if (instance == null) {
            synchronized (CityDatabaseHelper.class) {
                if (instance == null) {
                    instance = new CityDatabaseHelper(context);
                }
            }
        }
        return instance;
    }

