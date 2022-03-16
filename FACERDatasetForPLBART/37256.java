    @Override
    public void cacheCity(CityInfo city) {
        ArrayList<CityInfo> cityList = (ArrayList<CityInfo>) mACache.getAsObject(Extras.CITY_LIST);
        if (cityList == null) {
            cityList = new ArrayList<>();
        }
        CityInfo oldAutoLocate = null;
        for (CityInfo cityInfo : cityList) {
            if (cityInfo.isAutoLocate) {
                oldAutoLocate = cityInfo;
                break;
            }
        }
        if (oldAutoLocate != null) {
            oldAutoLocate.name = city.name;
        } else {
            cityList.add(city);
        }
        mACache.put(Extras.CITY, city);
        mACache.put(Extras.CITY_LIST, cityList);
    }

