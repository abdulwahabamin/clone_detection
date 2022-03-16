    @Override
    public void loadCities() {
        List<LoveCityEntity> cities = mCityRepository.getAllLoveCities();
        List<WeatherEntity> weathers = new ArrayList<>();
        Collections.sort(cities, new Comparator<LoveCityEntity>() {
            @Override
            public int compare(LoveCityEntity o1, LoveCityEntity o2) {
                return o1.getOrder() - o2.getOrder();
            }
        });
        for (LoveCityEntity entity : cities) {
            weathers.add(mWeatherRepository.getWeatherEntity(entity.getCityName()));
        }
        mView.showCities(weathers);
    }

