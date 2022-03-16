  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement, WeatherData.Coord model) {
    statement.bindNumberOrNull(1, model.getId());
    statement.bindDoubleOrNull(2, model.getLon());
    statement.bindDoubleOrNull(3, model.getLat());
    statement.bindNumberOrNull(4, model.getId());
  }

