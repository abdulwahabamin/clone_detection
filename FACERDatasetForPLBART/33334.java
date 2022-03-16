    @Override
    public void onClick(View view) {
        int listItemPosition = getListView().getPositionForView(view);
        int cityId = cursorAdapter.getCityId(listItemPosition);
        WeatherInfoType weatherInfoType = getRequestedWeatherInfoType(view);
        onWeatherInfoButtonClickedListener.onCityWeatherInfoRequested(cityId, weatherInfoType);
    }

