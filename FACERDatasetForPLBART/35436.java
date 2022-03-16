    @Override
    public void insertLoveCity(String cityName) {
        int order = mRepository.getAllLoveCities().size();
        LoveCityEntity loveCity = new LoveCityEntity();
        loveCity.setCityName(cityName);
        loveCity.setOrder(++order);
        mRepository.addLoveCity(loveCity);
    }

