    @Override
    public Observable<List<WeatherConditionEntity>> getWeatherConditionEntities() {

        return Observable.create(new Observable.OnSubscribe<List<WeatherConditionEntity>>() {
            @Override
            public void call(Subscriber<? super List<WeatherConditionEntity>> subscriber) {
                if (mDiskLruCache == null) {
                    subscriber.onError(new DiskCacheException("disk cache not exists"));
                } else {
                    try {
                        DiskLruCache.Snapshot snapshot = mDiskLruCache.get(StringUtil.bytesToMd5String(WEATHER_CONDITION_ENTITIES_CACHE_KEY.getBytes()));
                        if (snapshot != null) {
                            String weatherConditionEntitiesJson = snapshot.getString(0);
                            subscriber.onNext(mJsonProcesser.jsonToWeatherConditionEntities(weatherConditionEntitiesJson));
                            subscriber.onCompleted();
                        } else {
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

