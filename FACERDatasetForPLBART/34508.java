    /**
     * 查看�?个城市的天气情况
     * @param key 城市关键字
     *            3x ：cityid
     * @param action
     */
    public abstract void pickWeather(String key,Action1<WeatherBuilder> action);

