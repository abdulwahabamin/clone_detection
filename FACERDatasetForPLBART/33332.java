    @Override
    protected BaseCityCursorAdapter getCityCursorAdapter() {
        return new CityWeatherCursorAdapter(parentActivity,
                R.layout.row_city_list_with_weather_buttons, null,
                COLUMNS_TO_DISPLAY, TO, 0, this);
    }

