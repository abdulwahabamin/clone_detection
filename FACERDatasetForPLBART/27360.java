  @Override
  public final void loadFromCursor(FlowCursor cursor, LocationSearchHistory model) {
    model.setId(cursor.getLongOrDefault("id", null));
    model.setCityName(cursor.getStringOrDefault("cityName"));
    model.setCountyName(cursor.getStringOrDefault("countyName"));
    model.setWeatherType(cursor.getIntOrDefault("weatherType", null));
    model.setTemperature(cursor.getDoubleOrDefault("temperature", null));
    model.setLat(cursor.getDoubleOrDefault("lat", null));
    model.setLon(cursor.getDoubleOrDefault("lon", null));
  }

