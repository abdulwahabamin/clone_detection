    @Override
    public void onItemClick(CityEntity cityEntity) {
        if (currentType == CityType.PROVINCE) {
            currentProvince = cityEntity.getProvince();
            showCity(currentProvince);
        } else if (currentType == CityType.CITY) {
            showArea(cityEntity.getCity());
        } else if (currentType == CityType.AREA || currentType == CityType.SEARCH) {
            backToWeather(cityEntity.getArea(), false);
        }
    }

