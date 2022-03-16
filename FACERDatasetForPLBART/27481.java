  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, WeatherData.Weather model,
      int start) {
    statement.bindNumberOrNull(1 + start, model.getId());
    statement.bindStringOrNull(2 + start, model.getIcon());
    statement.bindStringOrNull(3 + start, model.getDescription());
    statement.bindStringOrNull(4 + start, model.getMain());
  }

