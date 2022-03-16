  @Override
  public final boolean exists(WeatherData model, DatabaseWrapper wrapper) {
    return SQLite.selectCountOf()
    .from(WeatherData.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

