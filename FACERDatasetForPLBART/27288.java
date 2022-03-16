  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement, WeatherData.Clouds model) {
    statement.bindNumberOrNull(1, model.getId());
    statement.bindNumberOrNull(2, model.getAll());
    statement.bindNumberOrNull(3, model.getId());
  }

