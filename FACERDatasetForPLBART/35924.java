    public static void init(ApiConfiguration apiConfiguration) {

        configuration = apiConfiguration;
        String weatherApiHost;
        switch (configuration.getDataSourceType()) {
            case ApiConstants.WEATHER_DATA_SOURCE_TYPE_KNOW:
                weatherApiHost = ApiConstants.KNOW_WEATHER_API_HOST;
                weatherService = initWeatherService(weatherApiHost, WeatherService.class);
                break;
            case ApiConstants.WEATHER_DATA_SOURCE_TYPE_MI:
                weatherApiHost = ApiConstants.MI_WEATHER_API_HOST;
                weatherService = initWeatherService(weatherApiHost, WeatherService.class);
                break;
            case ApiConstants.WEATHER_DATA_SOURCE_TYPE_ENVIRONMENT_CLOUD:
                weatherApiHost = ApiConstants.ENVIRONMENT_CLOUD_WEATHER_API_HOST;
                environmentCloudWeatherService = initWeatherService(weatherApiHost, EnvironmentCloudWeatherService.class);
                break;
        }
    }

