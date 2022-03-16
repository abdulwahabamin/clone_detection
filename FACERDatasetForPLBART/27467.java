  @Override
  public final boolean exists(WeatherForecastData model, DatabaseWrapper wrapper) {
    return SQLite.selectCountOf()
    .from(WeatherForecastData.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

