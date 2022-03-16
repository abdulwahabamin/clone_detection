    @Override
    public void onCreate() {
        mCity = model.getCurrentCity();
        // 首次进入
        if (mCity == null) {
            mCity = new CityInfo("正在定�?", true);
        }
        view.setTitle(mCity.name);
        view.setSpeechFabAnimation(false);

        Weather weather = model.getWeatherFromCache(mCity);
        if (weather != null) {
            view.showWeather(weather);
        } else {
            view.hideWeatherView();
        }
        if (weather == null || Utils.shouldRefresh(view.getContext())) {
            view.setRefreshing(true);
            onRefresh();
        }
    }

