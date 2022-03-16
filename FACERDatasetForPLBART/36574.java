    /**
     * 构造方法�?有化
     *
     * @param context
     */
    private SimpleWeatherDB(Context context) {
        SimpleWeatherOpenHelper dbHelper = new SimpleWeatherOpenHelper(context, DB_NAME, null, VERSION);
        db = dbHelper.getWritableDatabase();
    }

