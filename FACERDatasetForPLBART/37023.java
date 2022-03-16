    @Override
    public List<String> getAddedCity(Context context) {
        List<String> addedCityList = new ArrayList<>();
        ACache cache = ACache.get(context);
        List<CityInfo> cityList = (List<CityInfo>) cache.getAsObject(Extras.CITY_LIST);
        for (CityInfo cityInfo : cityList) {
            if (!cityInfo.isAutoLocate) {
                addedCityList.add(cityInfo.name);
            }
        }
        return addedCityList;
    }

