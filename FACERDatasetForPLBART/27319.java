  @Override
  public final void loadFromCursor(FlowCursor cursor, WeatherData.Coord model) {
    model.setId(cursor.getIntOrDefault("id", null));
    model.setLon(cursor.getDoubleOrDefault("lon", null));
    model.setLat(cursor.getDoubleOrDefault("lat", null));
  }

