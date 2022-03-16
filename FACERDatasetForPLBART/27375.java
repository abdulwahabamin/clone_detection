  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, WeatherData.Main model,
      int start) {
    statement.bindStringOrNull(1 + start, model.getHumidity());
    statement.bindStringOrNull(2 + start, model.getPressure());
    statement.bindStringOrNull(3 + start, model.getTemp_max());
    statement.bindStringOrNull(4 + start, model.getTemp_min());
    statement.bindStringOrNull(5 + start, model.getTemp());
    statement.bindDoubleOrNull(6 + start, model.getSea_level());
    statement.bindDoubleOrNull(7 + start, model.getGrnd_level());
    statement.bindDoubleOrNull(8 + start, model.getTemp_kf());
  }

