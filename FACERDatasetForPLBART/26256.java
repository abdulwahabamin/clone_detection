    public FollowedCityHolder(View itemView, BaseRecyclerAdapter baseRecyclerAdapter) {
        super(itemView, baseRecyclerAdapter);
        mCityWeatherAdapter = (CityWeatherAdapter) mBaseAdapter;
        mCityModel = ModelProvider.getModel(getContext(),CityModel.class);
        initViews();

    }

