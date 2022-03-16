  /**
   * Check version of SDK
   *
   * @param version int SDK version
   * @return boolean value
   */
  static boolean isAtLeastVersion(int version) {
    return Build.VERSION.SDK_INT >= version;
  }

