  /**
   * Get query of multipleDaysWeatherBox
   *
   * @param multipleDaysWeatherBox instance of {@link Box<MultipleDaysWeather>}
   * @return instance of {@link Query<MultipleDaysWeather>}
   */
  public static Query<MultipleDaysWeather> getMultipleDaysWeatherQuery(Box<MultipleDaysWeather> multipleDaysWeatherBox) {
    return multipleDaysWeatherBox.query().build();
  }

