    public void loadData() {
        mView.hideLocatedCityName();
        mView.hideCityNameEdit();
        mView.hideRetry();
        mView.showLoading();
        mUseCase.execute(new CitiesSubscriber());
    }

