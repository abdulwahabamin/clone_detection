  /**
   * If thirty minutes is pass from parameter return true otherwise return false
   *
   * @param lastStored timestamp
   * @return boolean value
   */
  public static boolean isTimePass(long lastStored) {
    return System.currentTimeMillis() - lastStored > Constants.TIME_TO_PASS;
  }

