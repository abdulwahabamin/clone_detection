    @Override
    protected void initDataObserver() {
        super.initDataObserver();
        mSearchModel = ModelProvider.getModel(this,SearchModel.class);
        mSearchModel.getAllCities();
        mSearchModel.getAllCityData().observe(this, new Observer<List<CityInfoData>>() {

            @Override
            public void onChanged(@Nullable List<CityInfoData> cityInfoData) {
                onAllCities(cityInfoData);
            }
        });
        mSearchModel.getMatchedCityData().observe(this, new Observer<List<CityInfoData>>() {
            @Override
            public void onChanged(@Nullable List<CityInfoData> cityInfoData) {
                onMatched(cityInfoData);
            }
        });

    }

