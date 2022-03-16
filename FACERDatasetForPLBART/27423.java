  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, WeatherData.Sys model,
      int start) {
    statement.bindStringOrNull(1 + start, model.getMessage());
    statement.bindNumberOrNull(2 + start, model.getId());
    statement.bindNumberOrNull(3 + start, model.getSunset());
    statement.bindNumberOrNull(4 + start, model.getSunrise());
    statement.bindNumberOrNull(5 + start, model.getType());
    statement.bindStringOrNull(6 + start, model.getCountry());
    statement.bindStringOrNull(7 + start, model.getPod());
  }

