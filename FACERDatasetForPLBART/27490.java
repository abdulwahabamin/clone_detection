  @Override
  public final void loadFromCursor(FlowCursor cursor, WeatherData.Weather model) {
    model.setWId(cursor.getIntOrDefault("wId", null));
    model.setId(cursor.getIntOrDefault("id", null));
    model.setIcon(cursor.getStringOrDefault("icon"));
    model.setDescription(cursor.getStringOrDefault("description"));
    model.setMain(cursor.getStringOrDefault("main"));
  }

