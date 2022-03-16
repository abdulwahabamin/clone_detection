    @Override
    public void saveCities(List<OrmCity> cities) {
        OrmCityDao cityDao = daoSession.getOrmCityDao();
        cityDao.insertInTx(cities);
        if (cities!=null && !cities.isEmpty()){
            EventBus.getDefault().post(new ChangeEvent(ChangeEvent.CHANGE_CONTENT));
        }

    }

