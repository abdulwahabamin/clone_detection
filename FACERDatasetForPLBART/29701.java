  /**
   * Get animation file according to weather status code
   *
   * @param weatherCode int weather status code
   * @return id of animation json file
   */
  public static int getWeatherAnimation(int weatherCode) {
    if (weatherCode / 100 == 2) {
      return R.raw.storm_weather;
    } else if (weatherCode / 100 == 3) {
      return R.raw.rainy_weather;
    } else if (weatherCode / 100 == 5) {
      return R.raw.rainy_weather;
    } else if (weatherCode / 100 == 6) {
      return R.raw.snow_weather;
    } else if (weatherCode / 100 == 7) {
      return R.raw.unknown;
    } else if (weatherCode == 800) {
      return R.raw.clear_day;
    } else if (weatherCode == 801) {
      return R.raw.few_clouds;
    } else if (weatherCode == 803) {
      return R.raw.broken_clouds;
    } else if (weatherCode / 100 == 8) {
      return R.raw.cloudy_weather;
    }
    return R.raw.unknown;
  }

