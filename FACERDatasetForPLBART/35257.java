    @Override
    public void deleteCity(String cityName) {
        getLoveCity(cityName, new GetLoveCityCallBack() {
            @Override
            public void onSuccess(List<LoveCityEntity> loveCities) {
                mLoveCityDao.delete(loveCities.get(0));
            }

            @Override
            public void onFailure(String failureMessage) {
                Logger.e("没有�?删除的城市数�?�");
            }
        });
    }

