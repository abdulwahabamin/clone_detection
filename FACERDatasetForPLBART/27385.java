  @Override
  public final boolean exists(WeatherData.Main model, DatabaseWrapper wrapper) {
    return (model.getId() != null && model.getId() > 0 || model.getId() == null)
    && SQLite.selectCountOf()
    .from(WeatherData.Main.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

