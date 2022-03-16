  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement,
      LocationSearchHistory model) {
    statement.bindNumberOrNull(1, model.getId());
    statement.bindStringOrNull(2, model.getCityName());
    statement.bindStringOrNull(3, model.getCountyName());
    statement.bindNumberOrNull(4, model.getWeatherType());
    statement.bindDoubleOrNull(5, model.getTemperature());
    statement.bindDoubleOrNull(6, model.getLat());
    statement.bindDoubleOrNull(7, model.getLon());
    statement.bindNumberOrNull(8, model.getId());
  }

