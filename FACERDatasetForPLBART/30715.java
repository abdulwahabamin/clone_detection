    @Override
    public void addData(CityWeather cityWeather) {

        cityWeatherAdapter.addCityWeather(cityWeather);
        cityWeatherRecyclerView.scrollToPosition(0);
    }

