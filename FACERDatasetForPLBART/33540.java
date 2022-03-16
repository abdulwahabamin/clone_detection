    @Override
    public void onFoundCityNamesItemClicked(int position) {
        AddCityFragment addCityFragment = (AddCityFragment) getSupportFragmentManager()
                .findFragmentByTag(ADD_CITY_FRAGMENT_TAG);
        if (addCityFragment != null) {
            addCityFragment.dismiss();
        }

        if (searchView != null) {
            searchView.onActionViewCollapsed();
        }

        if (searchResponseForFindQuery != null) {
            CityCurrentWeather selectedCityWeather = searchResponseForFindQuery
                    .getCities().get(position);
            String currentWeatherJsonString = new Gson().toJson(selectedCityWeather);

            if (isDualPane) {
                displayRetrievedDataInThisActivity(currentWeatherJsonString,
                        WeatherInfoType.CURRENT_WEATHER);
            }

            // Since the Open Weather Map search response for the 'find cities' query contains the
            // current weather information for each found city, we can cache this weather
            // information for the selected city in the database, just in case the user requests it
            // shortly (quite likely, given that s/he had just selected the city).
            insertNewRecordOrUpdateCity(selectedCityWeather.getCityId(),
                    selectedCityWeather.getCityName(), currentWeatherJsonString);
            saveWeatherInfoRequest(selectedCityWeather.getCityId(),
                    WeatherInfoType.CURRENT_WEATHER);
        }
    }

