    @Override
    public void initViews() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRecyclerView.setBackgroundResource(R.color.main_background);

        mSubscribeCityAdapter = new CityWeatherAdapter(getContext());
        mSubscribeCityAdapter.registerHolder(FollowedCityHolder.class, R.layout.city_item_followed_city);
        mSubscribeCityAdapter.registerHolder(AddHolder.class, R.layout.city_item_add_city);
        mRecyclerView.setAdapter(mSubscribeCityAdapter);

    }

