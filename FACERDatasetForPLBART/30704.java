    @Override
    public void onFavoriteSelected(CityWeather cityWeather) {

        if (cityWeather.isFavorite()) {

            cityWeather.setFavorite(false);
            dataManager
                    .removeCityWeatherFromFavorites(cityWeather)
                    .compose(applySchedulers())
                    .subscribe(aVoid -> {
                        if (getView() != null) {

                            getView().showRemovedFromFavoritesSuccessful(cityWeather);
                        }

                    }, throwable -> {

                        cityWeather.setFavorite(true);

                        throwable.printStackTrace();
                        if (getView() != null) {

                            getView().showRemovedFromFavoritesFailed(cityWeather);
                        }
                    });
        } else {

            cityWeather.setFavorite(true);
            dataManager
                    .addCityWeatherToFavorites(cityWeather)
                    .compose(applySchedulers())
                    .subscribe(aVoid -> {

                        if (getView() != null) {

                            getView().showSetToFavoritesSuccessful(cityWeather);
                        }
                    }, throwable -> {

                        cityWeather.setFavorite(false);
                        throwable.printStackTrace();
                        if (getView() != null) {

                            getView().showSetToFavoritesFailed(cityWeather);
                        }
                    });
        }
    }

