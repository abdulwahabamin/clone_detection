    @Override
    public void saveCity(OrmCity city) {
        OrmCityDao cityDao = daoSession.getOrmCityDao();
        cityDao.insertOrReplace(city);
        EventBus.getDefault().post(new ChangeEvent(ChangeEvent.CHANGE_CONTENT));
    }

