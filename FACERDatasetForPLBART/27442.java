  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, WeatherData model,
      int start) {
    statement.bindNumberOrNull(1 + start, model.getId());
    statement.bindNumberOrNull(2 + start, model.getDt());
    statement.bindNumberOrNull(3 + start, model.getCod());
    statement.bindStringOrNull(4 + start, model.getVisibility());
    statement.bindStringOrNull(5 + start, model.getName());
    statement.bindStringOrNull(6 + start, model.getBase());
  }

