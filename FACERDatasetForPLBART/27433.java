  @Override
  public final boolean exists(WeatherData.Sys model, DatabaseWrapper wrapper) {
    return (model.getSysId() != null && model.getSysId() > 0 || model.getSysId() == null)
    && SQLite.selectCountOf()
    .from(WeatherData.Sys.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

