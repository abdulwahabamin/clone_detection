  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement, WeatherData.Main model) {
    statement.bindNumberOrNull(1, model.getId());
    statement.bindStringOrNull(2, model.getHumidity());
    statement.bindStringOrNull(3, model.getPressure());
    statement.bindStringOrNull(4, model.getTemp_max());
    statement.bindStringOrNull(5, model.getTemp_min());
    statement.bindStringOrNull(6, model.getTemp());
    statement.bindDoubleOrNull(7, model.getSea_level());
    statement.bindDoubleOrNull(8, model.getGrnd_level());
    statement.bindDoubleOrNull(9, model.getTemp_kf());
    statement.bindNumberOrNull(10, model.getId());
  }

