    public Observable<Boolean> isCityWeatherFavorite(long id) {
        return databaseHelper
                .findFavoriteCityWeatherById(id)
                .map(cityWeather -> {

                    if (cityWeather != null) {

                        return cityWeather.isFavorite();
                    } else {

                        return false;
                    }
                });
    }

