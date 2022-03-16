  private void checkTimePass() {
    apiKey = getResources().getString(R.string.open_weather_map_api);
    if (prefser.contains(Constants.LAST_STORED_MULTIPLE_DAYS)) {
      requestWeather();
    } else {
      checkCityInfoExist();
    }
  }

