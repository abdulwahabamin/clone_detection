    @Override
    public void bindView(@NonNull FiveDayWeather item, @NonNull List<Object> payloads) {
      cardView.setCardBackgroundColor(item.getColor());
      int[] colors = {
          Color.TRANSPARENT,
          item.getColorAlpha(),
          Color.TRANSPARENT
      };
      Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      calendar.setTimeInMillis(item.getDt() * 1000L);
      if (AppUtil.isRTL(context)) {
        dayNameTextView.setText(Constants.DAYS_OF_WEEK_PERSIAN[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
      } else {
        dayNameTextView.setText(Constants.DAYS_OF_WEEK[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
      }
      if (item.maxTemp < 0 && item.maxTemp > -0.5) {
        item.maxTemp = 0;
      }
      if (item.minTemp < 0 && item.minTemp > -0.5) {
        item.minTemp = 0;
      }
      if (item.temp < 0 && item.temp > -0.5) {
        item.temp = 0;
      }
      tempTextView.setText(String.format(Locale.getDefault(), "%.0f°", item.getTemp()));
      minTempTextView.setText(String.format(Locale.getDefault(), "%.0f°", item.getMinTemp()));
      maxTempTextView.setText(String.format(Locale.getDefault(), "%.0f°", item.getMaxTemp()));
      AppUtil.setWeatherIcon(context, weatherImageView, item.weatherId);
      GradientDrawable shape = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors);
      shape.setShape(GradientDrawable.OVAL);
      shadowView.setBackground(shape);
    }

