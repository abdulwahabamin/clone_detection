  @Override
  public final void bindToStatement(DatabaseStatement statement, WeatherData.Sys model) {
    int start = 0;
    statement.bindNumberOrNull(1 + start, model.getSysId());
    bindToInsertStatement(statement, model, 1);
  }

