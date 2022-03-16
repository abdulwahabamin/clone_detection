    public void loadData() {
        if (mView != null) {
            mView.hideRetry();
            mView.showLoading();
            mView.showRefreshing();
        }
        if (mUseCase != null) {
            mUseCase.execute(new CityWeatherSubscriber());
        }
    }

