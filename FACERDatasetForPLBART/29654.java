  private void getCurrentWeather(String cityName, boolean isSearch) {
    apiKey = getResources().getString(R.string.open_weather_map_api);
    disposable.add(
        apiService.getCurrentWeather(
            cityName, Constants.UNITS, defaultLang, apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new DisposableSingleObserver<CurrentWeatherResponse>() {
              @Override
              public void onSuccess(CurrentWeatherResponse currentWeatherResponse) {
                isLoad = true;
                storeCurrentWeather(currentWeatherResponse);
                storeCityInfo(currentWeatherResponse);
                swipeContainer.setRefreshing(false);
                if (isSearch) {
                  prefser.remove(Constants.LAST_STORED_MULTIPLE_DAYS);
                }
              }

              @Override
              public void onError(Throwable e) {
                swipeContainer.setRefreshing(false);
                try {
                  HttpException error = (HttpException) e;
                  handleErrorCode(error);
                } catch (Exception exception) {
                  e.printStackTrace();
                }
              }
            })

    );
  }

