    @Override
    public void insertLoveCity(String cityName) {
        int order = mCityRepository.getAllLoveCities().size();
        LoveCityEntity loveCity = new LoveCityEntity();
        loveCity.setCityName(cityName);
        loveCity.setOrder(++order);
        mCityRepository.addLoveCity(loveCity);
    }

