  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, WeatherData.Coord model,
      int start) {
    statement.bindDoubleOrNull(1 + start, model.getLon());
    statement.bindDoubleOrNull(2 + start, model.getLat());
  }

