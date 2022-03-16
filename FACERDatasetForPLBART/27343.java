  @Override
  public final void loadFromCursor(FlowCursor cursor, WeatherForecastData.ForecastList model) {
    model.setId(cursor.getLongOrDefault("id", null));
    model.setDt(cursor.getLongOrDefault("dt", null));
    model.setDt_txt(cursor.getStringOrDefault("dt_txt"));
  }

