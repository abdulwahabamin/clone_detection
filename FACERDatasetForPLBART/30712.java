    /**
     * Toggles between a list and a grid recyclerview
     */
    private void toggleListGridLayout() {

        cityWeatherAdapter.setOnCityWeatherClickListener(null);
        List<CityWeather> cityWeatherList = cityWeatherAdapter.getCityWeatherList();

        if (isLinearLayoutEnabled) {

            cityWeatherRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            cityWeatherAdapter = new CityWeatherAdapter(getContext(), new ArrayList<>(), R.layout.item_city_weather);

        } else {
            cityWeatherRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            cityWeatherAdapter = new CityWeatherAdapter(getContext(), new ArrayList<>(), R.layout.item_city_weather_card);
        }

        cityWeatherAdapter.setOnCityWeatherClickListener(onCityWeatherClickListener);
        cityWeatherAdapter.setOnCityWeatherFavoriteSelectListener(onCityWeatherFavoriteSelectListener);
        cityWeatherAdapter.setCityWeatherList(cityWeatherList);
        cityWeatherRecyclerView.setAdapter(cityWeatherAdapter);
    }

