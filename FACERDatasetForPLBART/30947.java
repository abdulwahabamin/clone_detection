    @Override
    public Observable<List<WeatherConditionEntity>> getWeatherConditionEntities() {
        return mDiskCacheManager.getWeatherConditionEntities()
                .concatMap(new Func1<List<WeatherConditionEntity>, Observable<? extends List<WeatherConditionEntity>>>() {
                    @Override
                    public Observable<? extends List<WeatherConditionEntity>> call(List<WeatherConditionEntity> weatherConditionEntities) {
                        if (null == weatherConditionEntities) {
                            mIsWeatherConditionEntitiesDiskCacheExists = false;
                            return mServiceManager.getWeatherConditionEntities();
                        }
                        else {
                            mIsWeatherConditionEntitiesDiskCacheExists = true;
                            return Observable.just(weatherConditionEntities);
                        }
                    }
                }).doOnNext(new Action1<List<WeatherConditionEntity>>() {
                    @Override
                    public void call(List<WeatherConditionEntity> weatherConditionEntities) {
                        if (!mIsWeatherConditionEntitiesDiskCacheExists)
                            mDiskCacheManager.putWeatherConditionEntities(weatherConditionEntities);
                    }
                });
    }

