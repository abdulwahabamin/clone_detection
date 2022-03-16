  /**
   * Get time of calendar as 00:00 format
   *
   * @param calendar instance of {@link Calendar}
   * @param context  instance of {@link Context}
   * @return string value
   */
  public static String getTime(Calendar calendar, Context context) {
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);
    String hourString;
    if (hour < 10) {
      hourString = String.format(Locale.getDefault(), context.getString(R.string.zero_label), hour);
    } else {
      hourString = String.format(Locale.getDefault(), "%d", hour);
    }
    String minuteString;
    if (minute < 10) {
      minuteString = String.format(Locale.getDefault(), context.getString(R.string.zero_label), minute);
    } else {
      minuteString = String.format(Locale.getDefault(), "%d", minute);
    }
    return hourString + ":" + minuteString;
  }

