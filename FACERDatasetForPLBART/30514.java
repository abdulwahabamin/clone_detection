    private void initData(String location) {
        WeatherImpl weatherImpl = new WeatherImpl(this.getActivity(), this);
        weatherImpl.getWeatherHourly(location);
        weatherImpl.getAirForecast(location);
        weatherImpl.getAirNow(location);
        weatherImpl.getAlarm(location);
        weatherImpl.getWeatherForecast(location);
        weatherImpl.getWeatherNow(location);
    }

