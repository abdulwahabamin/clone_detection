    @Override
    public void getCities(String name, GetCityCallBack callBack) {
        List<CityEntity> res = mCityDao.queryBuilder().
                where(CityEntityDao.Properties.CityName.like("%" + name + "%")).
                list();

        if (isListEmpty(res)) {
            callBack.onFailure("该�?份下没有城市");
        } else {
            callBack.onSuccess(res);
        }
    }

