    @Override
    public void updateLocaitonCityOrder(String cityName, final int order) {
        getLoveCity(cityName, new GetLoveCityCallBack() {
            @Override
            public void onSuccess(List<LoveCityEntity> loveCities) {
                LoveCityEntity old = loveCities.get(0);
                old.setOrder(order);
                mLoveCityDao.update(old);
            }

            @Override
            public void onFailure(String failureMessage) {

            }
        });
    }

