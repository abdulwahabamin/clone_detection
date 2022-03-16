    @Override
    public void loadWeather() {
        String showCity = getShowCity();

        final HWeather weather = mWeatherRepository.getLocalWeather(showCity);
        if (weather == null) {
            doRefreshInNoData();
        } else {
            MainThreadAction.getInstance().post(new Runnable() {
                @Override
                public void run() {
                    mView.updateView(weather);
                }
            });
        }

    }

