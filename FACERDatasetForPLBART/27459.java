  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, WeatherForecastData model,
      int start) {
    statement.bindNumberOrNull(1 + start, model.getId());
    statement.bindStringOrNull(2 + start, model.getMessage());
    statement.bindNumberOrNull(3 + start, model.getCnt());
    statement.bindStringOrNull(4 + start, model.getCod());
    statement.bindNumberOrNull(5 + start, model.getDt());
  }

