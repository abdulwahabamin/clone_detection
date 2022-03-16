  @Override
  public final void loadFromCursor(FlowCursor cursor, WeatherForecastData model) {
    model.setId(cursor.getLongOrDefault("id", null));
    model.setMessage(cursor.getStringOrDefault("message"));
    model.setCnt(cursor.getLongOrDefault("cnt", null));
    model.setCod(cursor.getStringOrDefault("cod"));
    model.setDt(cursor.getLongOrDefault("dt", null));
  }

