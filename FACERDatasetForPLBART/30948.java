    @Override
    public Observable<WeatherEntity> getCityWeather(String cityId, boolean fromCache) {
        final String id = cityId;
        if (NetUtil.isNetworkAvailable(mContext) && !fromCache) {
            return mServiceManager.getCityWeather(cityId, false)
                    .doOnNext(new Action1<WeatherEntity>() {
                        @Override
                        public void call(WeatherEntity weatherEntity) {
                            mDiskCacheManager.putCityWeather(weatherEntity, id);
                        }
                    });
        }

        return mDiskCacheManager.getCityWeather(cityId, false)
                .concatMap(new Func1<WeatherEntity, Observable<? extends WeatherEntity>>() {
                    @Override
                    public Observable<? extends WeatherEntity> call(WeatherEntity weatherEntity) {
                        if (null == weatherEntity) {
                            Log.e(TAG, "Getting weather entity from disk cache failed.");
                            mIsWeatherEntityDiskCacheExists = false;
                            return mServiceManager.getCityWeather(id, false);
                        }
                        else {
                            Log.e(TAG, "Getting weather entity from disk cache succeeded.");
                            mIsWeatherEntityDiskCacheExists = true;
                            return Observable.just(weatherEntity);
                        }
                    }
                }).doOnNext(new Action1<WeatherEntity>() {
                    @Override
                    public void call(WeatherEntity weatherEntity) {
                        if (!mIsWeatherEntityDiskCacheExists)
                            mDiskCacheManager.putCityWeather(weatherEntity, id);
                    }
                });
    }

