  @Override
  public final void bindToInsertValues(ContentValues values, WeatherData.Weather model) {
    values.put("`id`", model.getId());
    values.put("`icon`", model.getIcon());
    values.put("`description`", model.getDescription());
    values.put("`main`", model.getMain());
  }

