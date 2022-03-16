  @Override
  public final void loadFromCursor(FlowCursor cursor, WeatherData.Wind model) {
    model.setId(cursor.getIntOrDefault("id", null));
    model.setSpeed(cursor.getStringOrDefault("speed"));
    model.setDeg(cursor.getStringOrDefault("deg"));
  }

