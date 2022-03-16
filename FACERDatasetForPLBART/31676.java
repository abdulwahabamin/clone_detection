    private void updateUI(double latitude, Locale locale, List<DetailedWeatherForecast> detailedWeatherForecast) {
        WeatherForecastItemAdapter adapter = new WeatherForecastItemAdapter(
                mContext,
                detailedWeatherForecast,
                latitude,
                locale,
                visibleColumns);
        mRecyclerView.setAdapter(adapter);
    }

