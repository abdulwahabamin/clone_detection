  @Override
  public final void bindToStatement(DatabaseStatement statement, WeatherData.Coord model) {
    int start = 0;
    statement.bindNumberOrNull(1 + start, model.getId());
    bindToInsertStatement(statement, model, 1);
  }

