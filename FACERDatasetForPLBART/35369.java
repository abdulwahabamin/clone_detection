    @Override
    public void getNewShowWeather() {
        String showCity = getShowCity();
        HWeather weather = mWeatherRepository.getLocalWeather(showCity);
        mView.updateView(weather);
    }

