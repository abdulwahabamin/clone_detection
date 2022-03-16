    @Override
    public Observable<List<CityEntity>> getCity(Context context, final String province) {
        return getAllCity(context)
                .filter(cityEntity -> cityEntity.getProvince().equals(province))
                .distinct(CityEntity::getCity)
                .toSortedList()
                .toObservable()
                .observeOn(AndroidSchedulers.mainThread());
    }

