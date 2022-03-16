    @Override
    public void search(String keyword) {
        keyword = keyword.replace(" ", "");
        this.keyword = keyword;
        if (TextUtils.isEmpty(keyword)) {
            view.cancelSearch();
            showProvince();
            return;
        }

        view.showSearching();
        String finalKeyword = keyword;
        model.search(view.getContext(), keyword)
                .subscribe(new Observer<List<CityEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<CityEntity> cityEntities) {
                        if (!AddCityPresenter.this.keyword.equals(finalKeyword)) {
                            return;
                        }
                        if (cityEntities.isEmpty()) {
                            view.showSearchError();
                        } else {
                            view.showSearchSuccess(cityEntities);
                            currentType = CityType.SEARCH;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (!AddCityPresenter.this.keyword.equals(finalKeyword)) {
                            return;
                        }
                        view.showSearchError();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

