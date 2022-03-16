    @Override
    public Observable<List<CityEntity>> getCityEntities() {
        return mDiskCacheManager.getCityEntities()
                .concatMap(new Func1<List<CityEntity>, Observable<? extends List<CityEntity>>>() {
                    @Override
                    public Observable<? extends List<CityEntity>> call(List<CityEntity> cityEntities) {
                        if (null == cityEntities) {
                            mIsCityEntitiesDiskCacheExists = false;
                            return mServiceManager.getCityEntities();
                        }
                        else {
                            mIsCityEntitiesDiskCacheExists = true;
                            return Observable.just(cityEntities);
                        }
                    }
                }).doOnNext(new Action1<List<CityEntity>>() {
                    @Override
                    public void call(List<CityEntity> cityEntities) {
                        if (!mIsCityEntitiesDiskCacheExists)
                            mDiskCacheManager.putCityEntities(cityEntities);
                    }
                });
    }

