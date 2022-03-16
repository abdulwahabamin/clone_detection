  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement, WeatherData model) {
    statement.bindNumberOrNull(1, model.getId());
    statement.bindNumberOrNull(2, model.getDt());
    statement.bindNumberOrNull(3, model.getCod());
    statement.bindStringOrNull(4, model.getVisibility());
    statement.bindStringOrNull(5, model.getName());
    statement.bindStringOrNull(6, model.getBase());
    statement.bindNumberOrNull(7, model.getId());
  }

