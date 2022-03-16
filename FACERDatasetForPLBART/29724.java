  /**
   * IranianCalendar: This method determines if the Iranian (Jalali) year is
   * leap (366-day long) or is the common year (365 days), and finds the day
   * in March (Gregorian Calendar)of the first day of the Iranian year
   * ('irYear').Iranian year (irYear) ranges from (-61 to 3177).This method
   * will set the following private data members as follows: leap: Number of
   * years since the last leap year (0 to 4) Gy: Gregorian year of the
   * begining of Iranian year march: The March day of Farvardin the 1st (first
   * day of jaYear)
   */
  private void IranianCalendar() {
    // Iranian years starting the 33-year rule
    int[] Breaks = {-61, 9, 38, 199, 426, 686, 756, 818, 1111, 1181, 1210,
        1635, 2060, 2097, 2192, 2262, 2324, 2394, 2456, 3178};
    int jm, N, leapJ, leapG, jp, j, jump;
    gYear = irYear + 621;
    leapJ = -14;
    jp = Breaks[0];
    // Find the limiting years for the Iranian year 'irYear'
    j = 1;
    do {
      jm = Breaks[j];
      jump = jm - jp;
      if (irYear >= jm) {
        leapJ += (jump / 33 * 8 + (jump % 33) / 4);
        jp = jm;
      }
      j++;
    } while ((j < 20) && (irYear >= jm));
    N = irYear - jp;
    // Find the number of leap years from AD 621 to the begining of the
    // current
    // Iranian year in the Iranian (Jalali) calendar
    leapJ += (N / 33 * 8 + ((N % 33) + 3) / 4);
    if (((jump % 33) == 4) && ((jump - N) == 4))
      leapJ++;
    // And the same in the Gregorian date of Farvardin the first
    leapG = gYear / 4 - ((gYear / 100 + 1) * 3 / 4) - 150;
    march = 20 + leapJ - leapG;
    // Find how many years have passed since the last leap year
    if ((jump - N) < 6)
      N = N - jump + ((jump + 4) / 33 * 33);
    leap = (((N + 1) % 33) - 1) % 4;
    if (leap == -1)
      leap = 4;
  }

