    @Override
    public Observable<List<CityEntity>> getArea(Context context, final String city) {
        return getAllCity(context)
                .filter(cityEntity -> cityEntity.getCity().equals(city))
                .toSortedList()
                .toObservable()
                .observeOn(AndroidSchedulers.mainThread());
    }

