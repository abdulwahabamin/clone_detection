    /**
     * å?•ä¾‹èŽ·å?–OpenHelperå®žä¾‹
     *
     * @param context application context
     * @return instance
     */
    public static WeatherDatabaseHelper getInstance(Context context) {

        context = context.getApplicationContext();
        if (instance == null) {
            synchronized (WeatherDatabaseHelper.class) {
                if (instance == null) {
                    instance = new WeatherDatabaseHelper(context);
                }
            }
        }
        return instance;
    }

