    @Override
    public void getAllProvince(final GetProvinceCallBack callBack) {
        Log.e(TAG, "getAllProvince已�?执行");
        List<ProvinceEntity> res = mProvinceDao.loadAll();
        if (isListEmpty(res)) {
            callBack.onFailure("数�?�为空");
        } else {
            callBack.onSuccess(res);

        }
    }

