  @Override
  public final void bindToInsertValues(ContentValues values, WeatherData.Sys model) {
    values.put("`message`", model.getMessage());
    values.put("`id`", model.getId());
    values.put("`sunset`", model.getSunset());
    values.put("`sunrise`", model.getSunrise());
    values.put("`type`", model.getType());
    values.put("`country`", model.getCountry());
    values.put("`pod`", model.getPod());
  }

