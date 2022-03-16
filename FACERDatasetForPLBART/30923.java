    @Override
    public Observable<WeatherEntity> getCityWeather(final String cityId, boolean fromCache) {
        return Observable.create(new Observable.OnSubscribe<WeatherEntity>() {
            @Override
            public void call(Subscriber<? super WeatherEntity> subscriber) {
                if (mDiskLruCache == null) {
                    subscriber.onError(new DiskCacheException("disk cache not exists"));
                } else {
                    try {
                        DiskLruCache.Snapshot snapshot = mDiskLruCache.get(StringUtil.bytesToMd5String((CITY_WEATHER_ENTITY_CACHE_KEY + cityId).getBytes()));
                        if (snapshot != null) {
                            String weatherEntityJson = snapshot.getString(0);
                            subscriber.onNext(mJsonProcesser.jsonToWeatherEntity(weatherEntityJson));
                            subscriber.onCompleted();
                        }
                        else {
                            subscriber.onNext(null);
                            subscriber.onCompleted();
                        }
                    } catch (IOException e) {
                        DiskCacheException diskCacheManager = new DiskCacheException("io failed");
                        diskCacheManager.initCause(e);
                        subscriber.onError(diskCacheManager);
                    }
                }
            }
        });
    }

