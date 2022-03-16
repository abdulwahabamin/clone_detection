    @Override
    public List<ProvinceEntity> getProvinces(String name) {
        return mProvinceDao.queryBuilder().
                where(ProvinceEntityDao.Properties.ProvinceName.like("%" + name + "%")).
                list();
    }

