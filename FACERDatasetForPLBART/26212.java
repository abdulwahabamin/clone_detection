    @Override
    public void loadCitys() {
        boolean cityInited = PreferencesHelper.get(CITY_INITED, false);
        if (cityInited) {
            return;
        }

        mCityHandler.post(new Runnable() {
            @Override
            public void run() {

                try {
                    String citys = FileHelper.assetFile2String("china_citys.txt", CoreManager.getContext());
                    JSONArray jsonArray = new JSONArray(citys);
                    List<City>  allCitys = new ArrayList<>();

                    for(int index =0 ; index < jsonArray.length() ;index++) {
                        JSONObject cityObject = jsonArray.getJSONObject(index);
                        CityEntry cityEntry = JsonHelper.fromJson(cityObject.toString(), CityEntry.class);

                        for(CityEntry.CityBean cityBean : cityEntry.getCity()) {
                            for(CityEntry.CityBean.CountyBean county : cityBean.getCounty()) {
                                City city = new City();
                                city.province = cityEntry.getName();
                                city.provinceEn = cityEntry.getName_en();
                                city.cityName = cityBean.getName();
                                city.cityId = county.getCode();
                                city.country = county.getName();
                                city.countryEn = county.getName_en();

                                allCitys.add(city);
                            }
                        }
                    }

                    Collections.sort(allCitys, new CityComparator());

                    mCityDatabase.cityDao().insertCities(allCitys);

                    PreferencesHelper.get(CITY_INITED, true);

                } catch (Exception e) {
                    LogHelper.error(TAG,"parse city info fail , %s",e);
                }

            }
        });
    }

