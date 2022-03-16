    private void loadDataFromDb(){
        List<CityWithWeather> cityWithWeatherList = new ArrayList<>();
        for (OrmCity ormCity : localDataSource.getCityList()) {
            CityWithWeather cityWithWeather = new CityWithWeather();
            cityWithWeather.setCity(ormCity);
            cityWithWeather.setWeather(localDataSource.getSingleForecast(ormCity.get_id()));
            cityWithWeatherList.add(cityWithWeather);
        }
        if (mAdapter!=null) {
            mAdapter.setCities(cityWithWeatherList);
        }
    }

