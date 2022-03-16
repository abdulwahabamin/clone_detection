    @Override
    public void showProvince() {
        view.showProgress("加载中…");
        model.getProvince(view.getContext())
                .subscribe(new Observer<List<CityEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<CityEntity> cityEntities) {
                        view.cancelProgress();
                        view.setTitle(view.getContext().getString(R.string.add_city));
                        view.showProvince(cityEntities);
                        currentType = CityType.PROVINCE;
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

