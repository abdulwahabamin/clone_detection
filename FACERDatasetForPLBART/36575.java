    /**
     * 获�?�SimpleWeatherDb的实例
     *
     * @param context
     * @return
     */
    public synchronized static SimpleWeatherDB getInstance(Context context) {
        if (simpleWeatherDB == null) {
            simpleWeatherDB = new SimpleWeatherDB(context);
        }
        return simpleWeatherDB;
    }

