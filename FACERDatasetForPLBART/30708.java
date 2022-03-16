    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        cityWeatherAdapter = new CityWeatherAdapter(getContext(), new ArrayList<>(), R.layout.item_city_weather_card);
        cityWeatherRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        ItemOffsetDecoration itemOffsetDecoration = new ItemOffsetDecoration(getContext(), R.dimen.item_offset);
        cityWeatherRecyclerView.addItemDecoration(itemOffsetDecoration);
        cityWeatherRecyclerView.setAdapter(cityWeatherAdapter);

        onCityWeatherClickListener = cityWeather -> {

            Intent intent = new Intent(getActivity(), CityWeatherDetailsActivity.class);
            intent.putExtra(CityWeatherDetailsActivity.CITY_ID_EXTRA, cityWeather.getId());
            intent.putExtra(CityWeatherDetailsActivity.CITY_NAME_EXTRA, cityWeather.getName());
            startActivity(intent);
        };

        onCityWeatherFavoriteSelectListener = cityWeather -> presenter.onFavoriteSelected(cityWeather);

        cityWeatherAdapter.setOnCityWeatherClickListener(onCityWeatherClickListener);
        cityWeatherAdapter.setOnCityWeatherFavoriteSelectListener(onCityWeatherFavoriteSelectListener);

        presenter.attachView(this);

        searchEditText.requestFocus();
        // Informing the presenter
        presenter.onSearchTextChanged(RxTextView.textChanges(searchEditText));
    }

