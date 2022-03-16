  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement, WeatherData.Wind model) {
    statement.bindNumberOrNull(1, model.getId());
    statement.bindStringOrNull(2, model.getSpeed());
    statement.bindStringOrNull(3, model.getDeg());
    statement.bindNumberOrNull(4, model.getId());
  }

