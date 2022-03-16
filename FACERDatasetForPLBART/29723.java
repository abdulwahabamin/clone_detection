  /**
   * setGregorianDate: Sets the date according to the Gregorian calendar and
   * adjusts the other dates.
   *
   * @param year  int
   * @param month int
   * @param day   int
   */
  public void setGregorianDate(int year, int month, int day) {
    gYear = year;
    gMonth = month;
    JDN = gregorianDateToJDN(year, month, day);
    JDNToIranian();
    JDNToJulian();
    JDNToGregorian();
  }

