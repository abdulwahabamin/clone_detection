    @Override
    public List<CityEntity> getCities(String name) {
        return mCityDao.queryBuilder().
                where(CityEntityDao.Properties.CityName.like("%" + name + "%")).
                list();
    }

