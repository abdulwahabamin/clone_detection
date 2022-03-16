    @Override
    public boolean isExistInCity(String name) {
        List<CityEntity> res = mCityDao.queryBuilder().
                where(CityEntityDao.Properties.CityName.eq(name)).
                list();
        if (isListEmpty(res)) {
            return false;
        } else {
            return true;
        }
    }

