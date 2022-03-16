  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement,
      WeatherForecastData.ForecastList model) {
    statement.bindNumberOrNull(1, model.getId());
    statement.bindNumberOrNull(2, model.getDt());
    statement.bindStringOrNull(3, model.getDt_txt());
    statement.bindNumberOrNull(4, model.getId());
  }

