    @Override
    public void loadCityData(String provinceName) {
        mCityRepository.getCityFromProvince(provinceName, new CityDataSource.GetCityCallBack() {
            @Override
            public void onSuccess(List<CityEntity> cities) {
                mView.showCityData(cities);
            }

            @Override
            public void onFailure(String failureMessage) {
                mView.showNoData();
            }
        });
    }

