    @Override
    public void getAllCity(GetCityCallBack callBack) {
        List<CityEntity> res = mCityDao.loadAll();
        if (isListEmpty(res)) {
            callBack.onFailure("该�?份下没有城市");
        } else {
            callBack.onSuccess(res);
        }
    }

