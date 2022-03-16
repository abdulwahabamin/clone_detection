  @Override
  public final void loadFromCursor(FlowCursor cursor, WeatherData.Sys model) {
    model.setSysId(cursor.getIntOrDefault("sysId", null));
    model.setMessage(cursor.getStringOrDefault("message"));
    model.setId(cursor.getIntOrDefault("id", null));
    model.setSunset(cursor.getLongOrDefault("sunset", null));
    model.setSunrise(cursor.getLongOrDefault("sunrise", null));
    model.setType(cursor.getIntOrDefault("type", null));
    model.setCountry(cursor.getStringOrDefault("country"));
    model.setPod(cursor.getStringOrDefault("pod"));
  }

