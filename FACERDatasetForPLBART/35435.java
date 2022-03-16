    @Override
    public void loadCities(String name) {
        cityList = new ArrayList<>();
        List<CityEntity> cities = mRepository.getCities(name);
        List<ProvinceEntity> provinces = mRepository.getProvinces(name);
        for (int i = 0; i < cities.size(); i++) {
            CityContext context = new CityContext();
            context.setCityName(cities.get(i).getCityName());
            cityList.add(context);
        }
        for (int i = 0; i < provinces.size(); i++) {
            CityContext context = new CityContext();
            context.setCityName(provinces.get(i).getProvinceName());
            if (!isInCityList(context.getCityName())) {
                cityList.add(context);
            }
        }
        mView.showQueryData(cityList);
    }

