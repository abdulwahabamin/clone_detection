    @Override
    public WeatherLive getWeatherLive() {

        WeatherLive weatherLive = new WeatherLive();
        weatherLive.setCityId(knowWeather.getCityId());
        weatherLive.setHumidity("");
        weatherLive.setTemp(knowWeather.getBasic().getTemp());
        weatherLive.setTime(DateConvertUtils.dateToTimeStamp(knowWeather.getBasic().getTime(),DateConvertUtils.DATA_FORMAT_PATTEN_YYYY_MM_DD_HH_MM_SS));
        weatherLive.setWeather(knowWeather.getBasic().getWeather());
        weatherLive.setWind("");
        weatherLive.setWindSpeed("");
        return weatherLive;
    }

