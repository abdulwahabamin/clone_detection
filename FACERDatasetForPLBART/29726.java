  /**
   * JDNToIranian: Converts the current value of 'JDN' Julian Day Number to a
   * date in the Iranian calendar. The caller should make sure that the
   * current value of 'JDN' is set correctly. This method first converts the
   * JDN to Gregorian calendar and then to Iranian calendar.
   */
  private void JDNToIranian() {
    JDNToGregorian();
    irYear = gYear - 621;
    IranianCalendar(); // This invocation will update 'leap' and 'march'
    int JDN1F = gregorianDateToJDN(gYear, 3, march);
    int k = JDN - JDN1F;
    if (k >= 0) {
      if (k <= 185) {
        irMonth = 1 + k / 31;
        irDay = (k % 31) + 1;
        return;
      } else
        k -= 186;
    } else {
      irYear--;
      k += 179;
      if (leap == 1)
        k++;
    }
    irMonth = 7 + k / 30;
    irDay = (k % 30) + 1;
  }

