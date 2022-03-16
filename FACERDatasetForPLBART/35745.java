    @Override
    public List<WeatherForecast> getWeatherForecasts() {

        List<WeatherForecast> weatherForecasts = new ArrayList<>();

        for (EnvironmentCloudForecast.ForecastEntity forecastEntity : cloudForecast.getForecast()) {

            WeatherForecast weatherForecast = new WeatherForecast();
            weatherForecast.setWind(forecastEntity.getWind().getDir());
            weatherForecast.setCityId(getCityId());
            weatherForecast.setHumidity(forecastEntity.getHum());
            weatherForecast.setMoonrise(forecastEntity.getAstro().getMr());
            weatherForecast.setMoonset(forecastEntity.getAstro().getMs());
            weatherForecast.setPop(forecastEntity.getPop());
            weatherForecast.setPrecipitation(forecastEntity.getPcpn());
            weatherForecast.setPressure(forecastEntity.getPres());
            weatherForecast.setSunrise(forecastEntity.getAstro().getSr());
            weatherForecast.setSunset(forecastEntity.getAstro().getSs());
            weatherForecast.setTempMax(Integer.parseInt(forecastEntity.getTmp().getMax()));
            weatherForecast.setTempMin(Integer.parseInt(forecastEntity.getTmp().getMin()));
            weatherForecast.setUv(forecastEntity.getUv());
            weatherForecast.setVisibility(forecastEntity.getVis());
//            weatherForecast.setWeather();
            weatherForecast.setWeatherDay(forecastEntity.getCond().getCond_d());
            weatherForecast.setWeatherNight(forecastEntity.getCond().getCond_n());
            weatherForecast.setWeek(DateConvertUtils.convertDataToWeek(forecastEntity.getDate()));
            weatherForecast.setDate(DateConvertUtils.convertDataToString(forecastEntity.getDate()));
            weatherForecasts.add(weatherForecast);
        }

        return weatherForecasts;
    }

