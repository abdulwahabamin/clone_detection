    @Override
    public WeatherLive getWeatherLive() {
        return new WeatherLive(miWeather.getRealTime().getCityId(),
                miWeather.getRealTime().getWeather(), miWeather.getRealTime().getTemp(),
                miWeather.getRealTime().getHumidity(), miWeather.getRealTime().getWind(),
                miWeather.getRealTime().getWindSpeed(), DateConvertUtils.dateToTimeStamp(miWeather.getRealTime().getTime(), DateConvertUtils.DATA_FORMAT_PATTEN_YYYY_MM_DD_HH_MM));
    }

