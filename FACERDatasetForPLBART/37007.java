    @Override
    public void showCity(final String province) {
        view.showProgress("加载中…");
        model.getCity(view.getContext(), province)
                .subscribe(new Observer<List<CityEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<CityEntity> cityEntities) {
                        view.cancelProgress();
                        view.setTitle(province);
                        view.showCity(cityEntities);
                        currentType = CityType.CITY;
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.cancelProgress();
                        view.finish();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

