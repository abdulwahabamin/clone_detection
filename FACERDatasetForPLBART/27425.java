  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement, WeatherData.Sys model) {
    statement.bindNumberOrNull(1, model.getSysId());
    statement.bindStringOrNull(2, model.getMessage());
    statement.bindNumberOrNull(3, model.getId());
    statement.bindNumberOrNull(4, model.getSunset());
    statement.bindNumberOrNull(5, model.getSunrise());
    statement.bindNumberOrNull(6, model.getType());
    statement.bindStringOrNull(7, model.getCountry());
    statement.bindStringOrNull(8, model.getPod());
    statement.bindNumberOrNull(9, model.getSysId());
  }

