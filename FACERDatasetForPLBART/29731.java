  /**
   * Get query of fiveDayWeatherBox
   *
   * @param fiveDayWeatherBox instance of {@link Box<FiveDayWeather>}
   * @return instance of {@link Query<FiveDayWeather>}
   */
  public static Query<FiveDayWeather> getFiveDayWeatherQuery(Box<FiveDayWeather> fiveDayWeatherBox) {
    return fiveDayWeatherBox.query().build();
  }

