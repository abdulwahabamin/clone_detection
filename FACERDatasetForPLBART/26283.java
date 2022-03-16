    @Override
    protected void initDataObserver() {
        mCityModel = ModelProvider.getModel(getActivity(),CityModel.class);
        mCityModel.getFollowedWeather().observe(this, new Observer<List<FollowedCityData>>() {
            @Override
            public void onChanged(@Nullable List<FollowedCityData> followedCityData) {
                onAllFollowedCities(followedCityData);
            }
        });
    }

