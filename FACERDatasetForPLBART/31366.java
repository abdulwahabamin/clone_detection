        @Override
        public void onNext(WeatherEntity weatherEntity) {
            if (mView != null) {
                CityWeatherPresenter.this.mView.setToolbarCity(weatherEntity.getCityName());
                CityWeatherPresenter.this.mView.showContent();
                CityWeatherPresenter.this.mView.renderCityWeather(weatherEntity);
                CityWeatherPresenter.this.mView.updateNotification(weatherEntity);
            }
        }

