    @Override
    public Observable<List<CityEntity>> getCityEntities() {
        return Observable.create(new Observable.OnSubscribe<List<CityEntity>>() {
            @Override
            public void call(Subscriber<? super List<CityEntity>> subscriber) {
                if (mDiskLruCache == null) {
                    subscriber.onError(new DiskCacheException("disk cache not exists"));
                } else {
                    try {
                        DiskLruCache.Snapshot snapshot = mDiskLruCache.get(StringUtil.bytesToMd5String(CITY_ENTITIES_CACHE_KEY.getBytes()));
                        if (snapshot != null) {
                            String cityEntitiesJson = snapshot.getString(0);
                            subscriber.onNext(mJsonProcesser.jsonToCityEntities(cityEntitiesJson));
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

