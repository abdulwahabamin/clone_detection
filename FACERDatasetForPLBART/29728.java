  /**
   * gergorianDateToJDN: Calculates the julian day number (JDN) from Gregorian
   * calendar dates. This integer number corresponds to the noon of the date
   * (i.e. 12 hours of Universal Time). This method was tested to be good
   * (valid) since 1 March, -100100 (of both calendars) up to a few millions
   * (10^6) years into the future. The algorithm is based on D.A.Hatcher,
   * Q.Jl.R.Astron.Soc. 25(1984), 53-55 slightly modified by K.M. Borkowski,
   * Post.Astron. 25(1987), 275-279.
   *
   * @param year  int
   * @param month int
   * @param day   int
   * @return int
   */
  private int gregorianDateToJDN(int year, int month, int day) {
    int jdn = (year + (month - 8) / 6 + 100100) * 1461 / 4
        + (153 * ((month + 9) % 12) + 2) / 5 + day - 34840408;
    jdn = jdn - (year + 100100 + (month - 8) / 6) / 100 * 3 / 4 + 752;
    return (jdn);
  }

