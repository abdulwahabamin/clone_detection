  private void requestWeathers(String cityName) {
    ApiService apiService = ApiClient.getClient().create(ApiService.class);
    disposable.add(
        apiService.getMultipleDaysWeather(
            cityName, Constants.UNITS, defaultLang, 16, apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new DisposableSingleObserver<MultipleDaysWeatherResponse>() {
              @Override
              public void onSuccess(MultipleDaysWeatherResponse response) {
                handleMultipleDaysResponse(response);
                swipeContainer.setRefreshing(false);
              }

              @Override
              public void onError(Throwable e) {
                swipeContainer.setRefreshing(false);
                Log.e("MainActivity", "onError: " + e.getMessage());
              }
            })
    );
  }

