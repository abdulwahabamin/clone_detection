    private List<OrmCity> loadCityListFromDb() {
        OrmCityDao cityDao = daoSession.getOrmCityDao();
        List<OrmCity> cities = cityDao.loadAll();
        if (cities.size() > 0) {
            return cities;
        } else {
            if (!PreferencesHelper.getInstance().isUseCurrentLocation(context) && BuildConfig.DEBUG) {
                cities.add(new OrmCity((long) 2, "Kiev", "Kievska Oblast", "Ukraine", 50.43, 30.52));
                cities.add(new OrmCity((long) 3, "London", "Greater London", "United Kingdom", 51.52, -0.11));
                cities.add(new OrmCity((long) 4, "Madrid", "Madrid", "Spain", 40.4, -3.68));
                saveCities(cities);
            }
            return cities;
        }
    }

