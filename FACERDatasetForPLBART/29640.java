  private void setVariables() {
    Intent intent = getIntent();
    fiveDayWeather = intent.getParcelableExtra(Constants.FIVE_DAY_WEATHER_ITEM);
    BoxStore boxStore = MyApplication.getBoxStore();
    itemHourlyDBBox = boxStore.boxFor(ItemHourlyDB.class);
    cardView.setCardBackgroundColor(fiveDayWeather.getColor());
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    calendar.setTimeInMillis(fiveDayWeather.getDt() * 1000L);
    if (AppUtil.isRTL(this)) {
      dayNameTextView.setText(Constants.DAYS_OF_WEEK_PERSIAN[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
    } else {
      dayNameTextView.setText(Constants.DAYS_OF_WEEK[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
    }
    if (fiveDayWeather.getMaxTemp() < 0 && fiveDayWeather.getMaxTemp() > -0.5) {
      fiveDayWeather.setMaxTemp(0);
    }
    if (fiveDayWeather.getMinTemp() < 0 && fiveDayWeather.getMinTemp() > -0.5) {
      fiveDayWeather.setMinTemp(0);
    }
    if (fiveDayWeather.getTemp() < 0 && fiveDayWeather.getTemp() > -0.5) {
      fiveDayWeather.setTemp(0);
    }
    tempTextView.setText(String.format(Locale.getDefault(), "%.0f°", fiveDayWeather.getTemp()));
    minTempTextView.setText(String.format(Locale.getDefault(), "%.0f°", fiveDayWeather.getMinTemp()));
    maxTempTextView.setText(String.format(Locale.getDefault(), "%.0f°", fiveDayWeather.getMaxTemp()));
    animationView.setAnimation(AppUtil.getWeatherAnimation(fiveDayWeather.getWeatherId()));
    animationView.playAnimation();
    typeface = Typeface.createFromAsset(getAssets(), "fonts/Vazir.ttf");
  }

