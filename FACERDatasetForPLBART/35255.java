    @Override
    public void updateCityOrder(final String cityName, final int order) {
        getLoveCity(cityName, new GetLoveCityCallBack() {
            @Override
            public void onSuccess(List<LoveCityEntity> loveCities) {
                LoveCityEntity old = getLoveCity(order);
                LoveCityEntity tmp = loveCities.get(0);
                int tmpOrder = tmp.getOrder();
                tmp.setOrder(order);
                old.setOrder(tmpOrder);
                mLoveCityDao.update(tmp);
                mLoveCityDao.update(old);
            }

            @Override
            public void onFailure(String failureMessage) {
                Logger.e("没有�?更新的城市数�?�");
            }
        });
    }

