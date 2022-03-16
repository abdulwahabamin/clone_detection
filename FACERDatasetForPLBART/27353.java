  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, LocationSearchHistory model,
      int start) {
    statement.bindNumberOrNull(1 + start, model.getId());
    statement.bindStringOrNull(2 + start, model.getCityName());
    statement.bindStringOrNull(3 + start, model.getCountyName());
    statement.bindNumberOrNull(4 + start, model.getWeatherType());
    statement.bindDoubleOrNull(5 + start, model.getTemperature());
    statement.bindDoubleOrNull(6 + start, model.getLat());
    statement.bindDoubleOrNull(7 + start, model.getLon());
  }

