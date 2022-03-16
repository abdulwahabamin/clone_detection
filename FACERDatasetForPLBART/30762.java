    public Observable<List<CityWeather>> getAllFavoriteCityWeather() {

        return databaseHelper
                .getAllFavoriteCityWeather()
                .flatMap(Observable::from)
                .flatMap(cityWeather -> getWeatherByCityId(cityWeather.getId()))
                .map(cityWeather -> {

                    cityWeather.setFavorite(true);
                    return cityWeather;
                })
                .toList();
    }

