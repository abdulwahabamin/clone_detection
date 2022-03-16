    @Override
    public Observable<List<CityEntity>> getProvince(Context context) {
        return getAllCity(context)
                .distinct(CityEntity::getProvince)
                .toSortedList()
                .toObservable()
                .observeOn(AndroidSchedulers.mainThread());
    }

