  private void requestWeather(String cityName, boolean isSearch) {
    if (AppUtil.isNetworkConnected()) {
      getCurrentWeather(cityName, isSearch);
      getFiveDaysWeather(cityName);
    } else {
      SnackbarUtil
          .with(swipeContainer)
          .setMessage(getString(R.string.no_internet_message))
          .setDuration(SnackbarUtil.LENGTH_LONG)
          .showError();
      swipeContainer.setRefreshing(false);
    }
  }

