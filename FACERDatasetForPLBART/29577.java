    @Override
    public void bindView(@NonNull MultipleDaysWeather item, @NonNull List<Object> payloads) {
      Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      calendar.setTimeInMillis(item.getDt() * 1000L);
      if (AppUtil.isRTL(context)) {
        DateConverter converter = new DateConverter(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH) + 1,
            calendar.get(Calendar.DAY_OF_MONTH));
        dayNameTextView.setText(Constants.DAYS_OF_WEEK_PERSIAN[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
        dateTextView.setText(String.format(Locale.getDefault(), "%d %s", converter.getIranianDay()
            , Constants.MONTH_NAME_PERSIAN[converter.getIranianMonth() - 1]));
      } else {
        dayNameTextView.setText(Constants.DAYS_OF_WEEK[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
        dateTextView.setText(String.format(Locale.getDefault(), "%s %d",
            Constants.MONTH_NAME[calendar.get(Calendar.MONTH)], calendar.get(Calendar.DAY_OF_MONTH)));
      }
      if (item.maxTemp < 0 && item.maxTemp > -0.5) {
        item.maxTemp = 0;
      }
      if (item.minTemp < 0 && item.minTemp > -0.5) {
        item.minTemp = 0;
      }
      minTempTextView.setText(String.format(Locale.getDefault(), "%.0f°", item.getMinTemp()));
      maxTempTextView.setText(String.format(Locale.getDefault(), "%.0f°", item.getMaxTemp()));
      AppUtil.setWeatherIcon(context, weatherImageView, item.getWeatherId());
    }

