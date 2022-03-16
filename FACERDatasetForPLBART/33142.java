    @Before
    public void setup() {
        detailedWeatherForecasts = new ArrayList<>();
        when(weatherForecastRecord.getCompleteWeatherForecast()).thenReturn(completeWeatherForecast);
        when(completeWeatherForecast.getWeatherForecastList()).thenReturn(detailedWeatherForecasts);
    }

