    @Override
    public void getWeatherForecast(final String location) {
        HeWeather.getWeatherForecast(context, location, lang, unit, new HeWeather.OnResultWeatherForecastBeanListener() {
            @Override
            public void onError(Throwable throwable) {
                Log.i("sky", "getWeatherForecast onError: ");
                Forecast weatherForecast = SpUtils.getBean(context, "weatherForecast", Forecast.class);
                weatherInterface.getWeatherForecast(weatherForecast);
                getAirForecast(location);
            }

            @Override
            public void onSuccess(Forecast list) {
                if (Code.OK.getCode().equalsIgnoreCase(list.getStatus())) {
                    weatherInterface.getWeatherForecast(list);
                    getAirForecast(location);
                    SpUtils.saveBean(context, "weatherForecast", list);
                }
            }
        });
    }

