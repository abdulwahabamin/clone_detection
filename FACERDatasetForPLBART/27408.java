  @Override
  public final void loadFromCursor(FlowCursor cursor, WeatherForecastData.Rain model) {
    model.setId(cursor.getLongOrDefault("id", null));
    model.setDt(cursor.getLongOrDefault("dt", null));
    model.setRainCount(cursor.getDoubleOrDefault("rainCount", null));
  }

