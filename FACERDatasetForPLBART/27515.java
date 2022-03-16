  @Override
  public final boolean exists(WeatherData.Wind model, DatabaseWrapper wrapper) {
    return (model.getId() != null && model.getId() > 0 || model.getId() == null)
    && SQLite.selectCountOf()
    .from(WeatherData.Wind.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

