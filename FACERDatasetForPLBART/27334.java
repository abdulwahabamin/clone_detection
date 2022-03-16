  @Override
  public final void bindToInsertStatement(DatabaseStatement statement,
      WeatherForecastData.ForecastList model, int start) {
    statement.bindNumberOrNull(1 + start, model.getDt());
    statement.bindStringOrNull(2 + start, model.getDt_txt());
  }

