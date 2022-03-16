  /**
   * Add days to calendar and return result
   *
   * @param cal  instance of {@link Calendar}
   * @param days number of days
   * @return instance of {@link Calendar}
   */
  public static Calendar addDays(Calendar cal, int days) {
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    calendar.setTimeInMillis(cal.getTimeInMillis());
    calendar.add(Calendar.DATE, days);
    return calendar;
  }

