    @Override
    public void updateCurrentWeather(CurrentWeatherData data) {
        if(data.getCity_id() == mCityId) {
            setAdapter(new CityWeatherAdapter(data, mDataSetTypes, getContext()));
        }
    }

