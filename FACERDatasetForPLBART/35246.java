    @Override
    public void getProvince(String name, GetProvinceCallBack callBack) {
        List<ProvinceEntity> res = mProvinceDao.queryBuilder().
                where(ProvinceEntityDao.Properties.ProvinceName.like("%" + name + "%")).
                list();

        if (isListEmpty(res)) {
            callBack.onFailure("æ²¡æœ‰å?«æœ‰è¯¥å??å­—çœ?ä»½");
        } else {
            callBack.onSuccess(res);
        }
    }

