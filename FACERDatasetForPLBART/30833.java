    @Test
    public void searchForCityWeather() {

        // given
        String cityName = CITY_NAME;

        // when
        when(dataManager.getWeatherByCityName(cityName)).thenReturn(Observable.just(cityWeather));
        when(dataManager.isCityWeatherFavorite(anyLong())).thenReturn(Observable.just(true));
        presenter.onSearchTextChanged(Observable.just(cityName));

        // then
        verify(dataManager).getWeatherByCityName(anyString());
        verify(view).addData(cityWeather);
    }

