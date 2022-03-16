    @Override
    public void getProvince(String name, GetProvinceCallBack callBack) {
        List<ProvinceEntity> res = mProvinceDao.queryBuilder().
                where(ProvinceEntityDao.Properties.ProvinceName.like("%" + name + "%")).
                list();

        if (isListEmpty(res)) {
            callBack.onFailure("没有�?�有该�??字�?份");
        } else {
            callBack.onSuccess(res);
        }
    }

