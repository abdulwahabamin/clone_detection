    @Override
    public void showCityData(List<CityEntity> data) {
        for (CityEntity item : data) {
            CityContext cityContext = new CityContext();
            cityContext.setCityName(item.getCityName());
            cities.add(cityContext);
        }
    }

