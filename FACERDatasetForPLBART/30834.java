    @Test
    public void onFavorityCityWeatherSelectedShouldRemoveIt() {

        // given
        when(cityWeather.isFavorite()).thenReturn(true);
        when(dataManager.removeCityWeatherFromFavorites(anyObject())).thenReturn(Observable.just(null));

        // when
        presenter.onFavoriteSelected(cityWeather);

        // then
        verify(dataManager).removeCityWeatherFromFavorites(anyObject());
    }

