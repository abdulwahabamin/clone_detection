  /**
   * Get query of currentWeatherBox
   *
   * @param currentWeatherBox instance of {@link Box<CurrentWeather>}
   * @return instance of {@link Query<CurrentWeather>}
   */
  public static Query<CurrentWeather> getCurrentWeatherQuery(Box<CurrentWeather> currentWeatherBox) {
    return currentWeatherBox.query().build();
  }

