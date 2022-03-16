  @Override
  public final boolean exists(WeatherData.Clouds model, DatabaseWrapper wrapper) {
    return (model.getId() != null && model.getId() > 0 || model.getId() == null)
    && SQLite.selectCountOf()
    .from(WeatherData.Clouds.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

