  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement, WeatherData.Weather model) {
    statement.bindNumberOrNull(1, model.getWId());
    statement.bindNumberOrNull(2, model.getId());
    statement.bindStringOrNull(3, model.getIcon());
    statement.bindStringOrNull(4, model.getDescription());
    statement.bindStringOrNull(5, model.getMain());
    statement.bindNumberOrNull(6, model.getWId());
  }

