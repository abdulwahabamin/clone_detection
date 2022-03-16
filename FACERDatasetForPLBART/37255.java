    @Override
    public Observable<Weather> getWeatherFromNet(CityInfo cityInfo) {
        // HE_KEY是更新天气需�?的key，需�?从和风天气官网申请�?�方能更新天气
        return Api.getIApi().getWeather(cityInfo.name, BuildConfig.HE_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnNext(weatherData -> {
                    boolean success = weatherData.weathers.get(0).status.equals("ok");
                    if (!success) {
                        throw Exceptions.propagate(new Throwable(weatherData.weathers.get(0).status));
                    }
                })
                .map(weatherData -> weatherData.weathers.get(0))
                .doOnNext(weather -> {
                    cacheWeather(cityInfo, weather);
                    Utils.saveRefreshTime(context);
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

