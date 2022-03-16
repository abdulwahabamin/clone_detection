    @Override
    public Observable<List<CityEntity>> getCityEntities() {

        return weatherInfoService.getCityInfos(Constants.CITY_LIST_URL)
                .map(new Func1<String, List<CityEntity>>() {
                    @Override
                    public List<CityEntity> call(String citysResponse) {
                        /*
                        城市/地区编�?	    英文	        中文	  国家代�?	国家英文	    国家中文	�?英文	�?中文	所属上级市英文    所属上级市中文	纬度   	�?度
                        CN101010100	    beijing	    北京	     CN	     China	     中国	beijing	北京	       beijing	          北京	39.904989	116.405285
                        CN101010200	    haidian	    海淀	     CN	     China	     中国	beijing	北京	       beijing	          北京	39.956074	116.310316
                        CN101010300	    chaoyang	�?阳	     CN	     China	     中国	beijing	北京	       beijing	          北京	39.921489	116.486409
                        */

                        if (TextUtils.isEmpty(citysResponse)) {
                            throw new WeatherServiceException("no data");
                        }

                        mCityEntities.clear();
                        BufferedReader reader = null;
                        try {
                            reader = new BufferedReader(new StringReader(citysResponse));
                            String tempString;
                            while ((tempString = reader.readLine()) != null) {
                                if (tempString.startsWith(Constants.CITY_LIST_LINE_HEADER) || tempString.startsWith(Constants.CITY_LIST_LINE_HEADER_1)) {
                                    tempString = tempString.replace("|", "");
                                    tempString = tempString.trim();
                                    String [] cityFileds = tempString.split("\\s+");
                                    if (cityFileds.length >= Constants.CITY_LIST_FIELD_NUM) {
                                        CityEntity cityEntity = new CityEntity();
                                        cityEntity.setCityId(TextUtils.isEmpty(cityFileds[Constants.CITY_LIST_FIELD_ID]) ? CityEntity.DEFAULT_VALUE : cityFileds[Constants.CITY_LIST_FIELD_ID]);
                                        cityEntity.setCountry(TextUtils.isEmpty(cityFileds[Constants.CITY_LIST_FIELD_COUNTY]) ? CityEntity.DEFAULT_VALUE : cityFileds[Constants.CITY_LIST_FIELD_COUNTY]);
                                        cityEntity.setProvince(TextUtils.isEmpty(cityFileds[Constants.CITY_LIST_FIELD_PROVINCE]) ? CityEntity.DEFAULT_VALUE : cityFileds[Constants.CITY_LIST_FIELD_PROVINCE]);
                                        cityEntity.setCity(TextUtils.isEmpty(cityFileds[Constants.CITY_LIST_FIELD_CITY]) ? CityEntity.DEFAULT_VALUE : cityFileds[Constants.CITY_LIST_FIELD_CITY]);
                                        mCityEntities.add(cityEntity);
                                    }
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            if (reader != null) {
                                try {
                                    reader.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        /*if (!citysResponse.getResultCode().equals(Constants.OK)) {
                            throw new WeatherServiceException("error code: " + citysResponse.getResultCode());
                        }

                        mCityEntities.clear();
                        List<CitysResponse.CityInfo> cityInfos = citysResponse.getCitys();
                        if (cityInfos != null) {
                            for (CitysResponse.CityInfo cityInfo : cityInfos) {
                                if (cityInfo != null) {
                                    if (cityInfo.getId() != null && cityInfo.getId().length() > 7 && mNameMap.get(cityInfo.getId().subSequence(0, 7)) != null) {
                                        cityInfo.setProvince(mNameMap.get(cityInfo.getId().subSequence(0, 7)));
                                    }
                                    CityEntity cityEntity = new CityEntity();
                                    cityEntity.setCityId(TextUtils.isEmpty(cityInfo.getId()) ? CityEntity.DEFAULT_VALUE : cityInfo.getId());
                                    cityEntity.setCountry(TextUtils.isEmpty(cityInfo.getCountry()) ? CityEntity.DEFAULT_VALUE : cityInfo.getCountry());
                                    cityEntity.setProvince(TextUtils.isEmpty(cityInfo.getProvince()) ? CityEntity.DEFAULT_VALUE : cityInfo.getProvince());
                                    cityEntity.setCity(TextUtils.isEmpty(cityInfo.getCity()) ? CityEntity.DEFAULT_VALUE : cityInfo.getCity());
                                    mCityEntities.add(cityEntity);
                                }
                            }
                        }*/
                        return mCityEntities;
                    }
                });
    }

