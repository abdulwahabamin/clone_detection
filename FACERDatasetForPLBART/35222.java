    @Override
    public String getShowCity() {
        List<LoveCityEntity> entity = mLoveCityDao.queryBuilder().
                where(LoveCityEntityDao.Properties.Order.eq(1)).
                list();
        return entity.get(0).getCityName();
    }

