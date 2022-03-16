  @Override
  public final void bindToInsertValues(ContentValues values, LocationSearchHistory model) {
    values.put("`id`", model.getId());
    values.put("`cityName`", model.getCityName());
    values.put("`countyName`", model.getCountyName());
    values.put("`weatherType`", model.getWeatherType());
    values.put("`temperature`", model.getTemperature());
    values.put("`lat`", model.getLat());
    values.put("`lon`", model.getLon());
  }

