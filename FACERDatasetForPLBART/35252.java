    @Override
    public void getLoveCity(GetLoveCityCallBack callBack) {
        List<LoveCityEntity> res = mLoveCityDao.queryBuilder().
                orderAsc(LoveCityEntityDao.Properties.Order).
                list();

        if (isListEmpty(res)) {
            callBack.onFailure("没有喜欢的城市");
        } else {
            callBack.onSuccess(res);
        }
    }

