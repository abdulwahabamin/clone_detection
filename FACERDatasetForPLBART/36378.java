    @Override
    public void loadSavedCities() {

        try {
            Subscription subscription = Observable.just(weatherDao.queryAllSaveCity())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(weathers -> view.displaySavedCities(weathers));
            subscriptions.add(subscription);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

