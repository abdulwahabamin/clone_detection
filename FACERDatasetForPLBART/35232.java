    @Override
    public void addCities(UrlCity city) {
        Set<CityEntity> sets = new HashSet<>();
        for (int i = 0; i < city.getCity_info().size(); i++) {
            CityEntity entity = new CityEntity();
            entity.setProvinceName(city.getCity_info().get(i).getProv());
            entity.setCityName(city.getCity_info().get(i).getCity());
            sets.add(entity);
//            addCity(entity);
        }
        mCityDao.insertInTx(sets);
    }

