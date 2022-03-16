    @Override
    public void getLoveCity(int order, GetLoveCityCallBack callBack) {
        List<LoveCityEntity> res = mLoveCityDao.queryBuilder().
                where(LoveCityEntityDao.Properties.Order.eq(order)).list();

        if (isListEmpty(res)) {
            callBack.onFailure("没有喜欢的城市");
        } else {
            callBack.onSuccess(res);
        }
    }

