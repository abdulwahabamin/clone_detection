    @Override
    public void loadCityWeatherData(long id) {

        dataManager
                .getWeatherByCityId(id)
                .compose(applySchedulers())
                .subscribe(cityWeather -> {

                    if (getView() != null) {

                        getView().showCityWeatherData(cityWeather);
                    }
                });
    }

