  /**
   * Get weather status string according to weather status code
   *
   * @param weatherCode weather status code
   * @param isRTL       boolean value
   * @return String weather status
   */
  public static String getWeatherStatus(int weatherCode, boolean isRTL) {
    if (weatherCode / 100 == 2) {
      if (isRTL) {
        return Constants.WEATHER_STATUS_PERSIAN[0];
      } else {
        return Constants.WEATHER_STATUS[0];
      }
    } else if (weatherCode / 100 == 3) {
      if (isRTL) {
        return Constants.WEATHER_STATUS_PERSIAN[1];
      } else {
        return Constants.WEATHER_STATUS[1];
      }
    } else if (weatherCode / 100 == 5) {
      if (isRTL) {
        return Constants.WEATHER_STATUS_PERSIAN[2];
      } else {
        return Constants.WEATHER_STATUS[2];
      }
    } else if (weatherCode / 100 == 6) {
      if (isRTL) {
        return Constants.WEATHER_STATUS_PERSIAN[3];
      } else {
        return Constants.WEATHER_STATUS[3];
      }
    } else if (weatherCode / 100 == 7) {
      if (isRTL) {
        return Constants.WEATHER_STATUS_PERSIAN[4];
      } else {
        return Constants.WEATHER_STATUS[4];
      }
    } else if (weatherCode == 800) {
      if (isRTL) {
        return Constants.WEATHER_STATUS_PERSIAN[5];
      } else {
        return Constants.WEATHER_STATUS[5];
      }
    } else if (weatherCode == 801) {
      if (isRTL) {
        return Constants.WEATHER_STATUS_PERSIAN[6];
      } else {
        return Constants.WEATHER_STATUS[6];
      }
    } else if (weatherCode == 803) {
      if (isRTL) {
        return Constants.WEATHER_STATUS_PERSIAN[7];
      } else {
        return Constants.WEATHER_STATUS[7];
      }
    } else if (weatherCode / 100 == 8) {
      if (isRTL) {
        return Constants.WEATHER_STATUS_PERSIAN[8];
      } else {
        return Constants.WEATHER_STATUS[8];
      }
    }
    if (isRTL) {
      return Constants.WEATHER_STATUS_PERSIAN[4];
    } else {
      return Constants.WEATHER_STATUS[4];
    }
  }

