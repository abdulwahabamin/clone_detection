  @Override
  public final void bindToStatement(DatabaseStatement statement, WeatherData.Weather model) {
    int start = 0;
    statement.bindNumberOrNull(1 + start, model.getWId());
    bindToInsertStatement(statement, model, 1);
  }

