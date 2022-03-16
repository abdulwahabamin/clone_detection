    @Override
    public Observable<CityEntity> getAllCity(Context context) {
        return Observable.just(context)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map(context1 -> {
                    if (mCityList == null) {
                        String json = readJsonFromAssets(context1.getAssets());
                        mCityList = parseCityList(json);
                    }
                    return mCityList;
                })
                .flatMap(Observable::fromIterable);
    }

