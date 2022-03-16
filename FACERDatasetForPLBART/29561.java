    @Override
    public void bindView(@NonNull ItemHourlyDB item, @NonNull List<Object> payloads) {
      Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      calendar.setTimeInMillis(item.getDt() * 1000L);
      if (item.getTemp() < 0 && item.getTemp() > -0.5) {
        item.setTemp(0);
      }
      timeTextView.setText(AppUtil.getTime(calendar, context));
      tempTextView.setText(String.format(Locale.getDefault(), "%.0f°", item.getTemp()));
      AppUtil.setWeatherIcon(context, weatherImageView, item.weatherCode);
    }

