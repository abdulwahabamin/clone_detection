    @Override
    public WeatherLive getWeatherLive() {

        WeatherLive weatherLive = new WeatherLive();
        weatherLive.setAirPressure(cloudWeatherLive.getAirPressure());
        weatherLive.setCityId(cloudWeatherLive.getCityId());
        weatherLive.setFeelsTemperature(cloudWeatherLive.getFeelsTemperature());
        weatherLive.setHumidity(cloudWeatherLive.getHumidity());
        weatherLive.setRain(cloudWeatherLive.getRain());
        weatherLive.setTemp(cloudWeatherLive.getTemperature());
        weatherLive.setTime(DateConvertUtils.dateToTimeStamp(cloudWeatherLive.getUpdateTime(), DateConvertUtils.DATA_FORMAT_PATTEN_YYYY_MM_DD_HH_MM));
        weatherLive.setWeather(cloudWeatherLive.getPhenomena());
        weatherLive.setWind(cloudWeatherLive.getWindDirect());
        weatherLive.setWindPower(cloudWeatherLive.getWindPower());
        weatherLive.setWindSpeed(cloudWeatherLive.getWindSpeed());

        return weatherLive;
    }

