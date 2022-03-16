    @Override
    public Observable<List<WeatherConditionEntity>> getWeatherConditionEntities() {
        Map<String, String> params = new android.support.v4.util.ArrayMap<>(2);
        params.put("search", Constants.SEARCH_ALL_COND);
        params.put("key", Constants.WEATHER_KEY);

        return weatherInfoService.getConditionInfos(params)
                .map(new Func1<ConditionsResponse, List<WeatherConditionEntity>>() {
                    @Override
                    public List<WeatherConditionEntity> call(ConditionsResponse conditionsResponse) {
                        if (null == conditionsResponse) {
                            throw new WeatherServiceException("no data");
                        }
                        if (!conditionsResponse.getResultCode().equals(Constants.OK)) {
                            throw new WeatherServiceException("error code: " + conditionsResponse.getResultCode());
                        }

                        mWeatherCondtionEntities.clear();
                        List<ConditionsResponse.ConditionInfo> weatherConditionInfos = conditionsResponse.getConditions();
                        if (weatherConditionInfos != null) {
                            for (ConditionsResponse.ConditionInfo conditionInfo : weatherConditionInfos) {
                                if (conditionInfo != null) {
                                    WeatherConditionEntity conditionEntity = new WeatherConditionEntity();
                                    conditionEntity.setWeatherCode(TextUtils.isEmpty(conditionInfo.getConditionCode()) ? WeatherConditionEntity.DEFAULT_VALUE : conditionInfo.getConditionCode());
                                    conditionEntity.setWeatherDescription(TextUtils.isEmpty(conditionInfo.getWeatherDescription()) ? WeatherConditionEntity.DEFAULT_VALUE : conditionInfo.getWeatherDescription());
                                    conditionEntity.setWeatherIconUrl(TextUtils.isEmpty(conditionInfo.getWeatherIconUrl()) ? WeatherConditionEntity.DEFAULT_VALUE : conditionInfo.getWeatherIconUrl());
                                    mWeatherCondtionEntities.add(conditionEntity);
                                }
                            }
                        }
                        return mWeatherCondtionEntities;
                    }
                });
    }

