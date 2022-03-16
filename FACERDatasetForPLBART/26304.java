    void getAllCities() {
        CoreManager.getImpl(ICityRepositoryApi.class).getCityWorkHandler().post(new Runnable() {
            @Override
            public void run() {
                List<City>  allCity = CoreManager.getImpl(ICityRepositoryApi.class).queryAllCities();
                if(allCity !=null) {

                    List<CityInfoData> cityInfoDatas = new ArrayList<>();
                    String lastInitial = "";
                    for(City city : allCity) {
                        CityInfoData cityInfoData =  new CityInfoData(city.country,city.countryEn,city.cityId);
                        String currentInitial = city.countryEn.substring(0, 1);
                        if (!lastInitial.equals(currentInitial) ) {
                            cityInfoData.setInitial(currentInitial);
                            lastInitial = currentInitial;
                        }
                        cityInfoDatas.add(cityInfoData);
                    }
                    mAllCityData.postValue(cityInfoDatas);
                }
            }
        });
    }

