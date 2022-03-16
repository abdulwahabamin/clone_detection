  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement, WeatherForecastData model) {
    statement.bindNumberOrNull(1, model.getId());
    statement.bindStringOrNull(2, model.getMessage());
    statement.bindNumberOrNull(3, model.getCnt());
    statement.bindStringOrNull(4, model.getCod());
    statement.bindNumberOrNull(5, model.getDt());
    statement.bindNumberOrNull(6, model.getId());
  }

