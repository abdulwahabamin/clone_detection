    @Test
    public void onNonFavoriteCityWeatherSelectedShouldAddIt() {

        // given
        when(cityWeather.isFavorite()).thenReturn(false);
        when(dataManager.addCityWeatherToFavorites(anyObject())).thenReturn(Observable.just(null));

        // when
        presenter.onFavoriteSelected(cityWeather);

        // then
        verify(dataManager).addCityWeatherToFavorites(anyObject());
    }

