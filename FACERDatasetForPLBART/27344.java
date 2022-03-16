  @Override
  public final boolean exists(WeatherForecastData.ForecastList model, DatabaseWrapper wrapper) {
    return (model.getId() != null && model.getId() > 0 || model.getId() == null)
    && SQLite.selectCountOf()
    .from(WeatherForecastData.ForecastList.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

