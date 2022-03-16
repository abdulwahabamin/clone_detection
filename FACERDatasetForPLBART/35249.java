    @Override
    public void getLoveCity(String cityName, GetLoveCityCallBack callBack) {
        List<LoveCityEntity> res = mLoveCityDao.queryBuilder().
                where(LoveCityEntityDao.Properties.CityName.like(cityName)).
                list();

        if (isListEmpty(res)) {
            callBack.onFailure("没有喜欢的城市");
        } else {
            callBack.onSuccess(res);
        }
    }

