    void matchCities(final String key) {
        TaskScheduler.execute(new Runnable() {
            @Override
            public void run() {
                List<City> allCity = CoreManager.getImpl(ICityRepositoryApi.class).matchingCity(key);
                if(allCity !=null ) {

                    List<CityInfoData> cityInfoDatas = new ArrayList<>();
                    for(City city : allCity) {
                        cityInfoDatas.add(new CityInfoData(city.country,city.countryEn,city.cityId));
                    }
                    mMatchedCityData.postValue(cityInfoDatas);
                }
            }
        });
    }

