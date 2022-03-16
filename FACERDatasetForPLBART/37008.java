    @Override
    public void showArea(final String city) {
        view.showProgress("加载中…");
        model.getArea(view.getContext(), city)
                .subscribe(new Observer<List<CityEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<CityEntity> cityEntities) {
                        view.cancelProgress();
                        view.setTitle(city);
                        view.showArea(cityEntities);
                        currentType = CityType.AREA;
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

