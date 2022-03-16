    /**
     * http://weatherapi.market.xiaomi.com/wtr-v2/weather?cityId=101010100
     *
     * @param cityId 城市ID
     * @return 天气数�?�
     */
    @GET("weather")
    Observable<MiWeather> getMiWeather(@Query("cityId") String cityId);

