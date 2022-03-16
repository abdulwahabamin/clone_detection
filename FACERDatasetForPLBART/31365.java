        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            if (mView != null) {
                CityWeatherPresenter.this.mView.hideRefreshing();
                CityWeatherPresenter.this.mView.hideLoading();
                CityWeatherPresenter.this.mView.showRetry();
                CityWeatherPresenter.this.mView.showError(mView.getContext().getApplicationContext().getString(R.string.weather_update_failed));
            }
        }

