  @Override
  public final void loadFromCursor(FlowCursor cursor, WeatherData.Main model) {
    model.setId(cursor.getIntOrDefault("id", null));
    model.setHumidity(cursor.getStringOrDefault("humidity"));
    model.setPressure(cursor.getStringOrDefault("pressure"));
    model.setTemp_max(cursor.getStringOrDefault("temp_max"));
    model.setTemp_min(cursor.getStringOrDefault("temp_min"));
    model.setTemp(cursor.getStringOrDefault("temp"));
    model.setSea_level(cursor.getDoubleOrDefault("sea_level", null));
    model.setGrnd_level(cursor.getDoubleOrDefault("grnd_level", null));
    model.setTemp_kf(cursor.getDoubleOrDefault("temp_kf", null));
  }

