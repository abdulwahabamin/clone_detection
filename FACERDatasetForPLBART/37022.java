    @Override
    public Observable<List<CityEntity>> search(Context context, final String keyword) {
        return getAllCity(context)
                .filter(cityEntity -> cityEntity.getArea().contains(keyword))
                .toSortedList()
                .toObservable()
                .observeOn(AndroidSchedulers.mainThread());
    }

