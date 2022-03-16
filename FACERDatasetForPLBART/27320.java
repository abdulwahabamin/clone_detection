  @Override
  public final boolean exists(WeatherData.Coord model, DatabaseWrapper wrapper) {
    return (model.getId() != null && model.getId() > 0 || model.getId() == null)
    && SQLite.selectCountOf()
    .from(WeatherData.Coord.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

