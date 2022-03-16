  @Override
  public final boolean exists(WeatherForecastData.Rain model, DatabaseWrapper wrapper) {
    return (model.getId() != null && model.getId() > 0 || model.getId() == null)
    && SQLite.selectCountOf()
    .from(WeatherForecastData.Rain.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

