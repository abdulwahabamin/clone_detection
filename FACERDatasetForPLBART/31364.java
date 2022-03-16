        @Override
        public void onCompleted() {
            if (mView != null) {
                CityWeatherPresenter.this.mView.hideRefreshing();
                CityWeatherPresenter.this.mView.hideLoading();
                CityWeatherPresenter.this.mView.showError(mView.getContext().getApplicationContext().getString(R.string.weather_updated));
            }
        }

