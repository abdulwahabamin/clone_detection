    @Override
    public boolean isExistInLoveCity(String cityName) {
        List<LoveCityEntity> res = mLoveCityDao.queryBuilder().
                where(LoveCityEntityDao.Properties.CityName.like(cityName)).
                list();

        if (isListEmpty(res)) {
            return false;
        } else {
            return true;
        }
    }

