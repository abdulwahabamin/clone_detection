  @Override
  public final void loadFromCursor(FlowCursor cursor, WeatherData model) {
    model.setId(cursor.getLongOrDefault("id", null));
    model.setDt(cursor.getLongOrDefault("dt", null));
    model.setCod(cursor.getIntOrDefault("cod", null));
    model.setVisibility(cursor.getStringOrDefault("visibility"));
    model.setName(cursor.getStringOrDefault("name"));
    model.setBase(cursor.getStringOrDefault("base"));
  }

