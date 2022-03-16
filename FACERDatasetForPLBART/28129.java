    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "forecast")
    public abstract retrofit2.Call<com.quixom.apps.weatherstream.model.WeatherForecastData> getWeatherForecasting(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "x-api-key")
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap()
    java.util.HashMap<java.lang.String, java.lang.String> params);

