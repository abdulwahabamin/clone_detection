    @Override
    public void getFavoriteData() {

        dataManager
                .getAllFavoriteCityWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cityWeathers -> {
                    if (getView() != null) {

                        getView().showData(cityWeathers);
                    }
                }, throwable -> {

                    Log.e("Error", throwable.toString());
                });
    }

