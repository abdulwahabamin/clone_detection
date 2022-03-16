  @Override
  public final boolean exists(WeatherData.Weather model, DatabaseWrapper wrapper) {
    return (model.getWId() != null && model.getWId() > 0 || model.getWId() == null)
    && SQLite.selectCountOf()
    .from(WeatherData.Weather.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

