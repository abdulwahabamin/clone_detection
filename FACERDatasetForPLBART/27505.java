  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, WeatherData.Wind model,
      int start) {
    statement.bindStringOrNull(1 + start, model.getSpeed());
    statement.bindStringOrNull(2 + start, model.getDeg());
  }

