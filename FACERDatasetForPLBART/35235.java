    @Override
    public void getCityFromProvince(String provinceName, GetCityCallBack callBack) {
        List<CityEntity> res = mCityDao.queryBuilder().
                where(CityEntityDao.Properties.ProvinceName.like(provinceName)).
                list();
        if (isListEmpty(res)) {
            callBack.onFailure("该�?份下没有城市");
        } else {
            callBack.onSuccess(res);
        }
    }

