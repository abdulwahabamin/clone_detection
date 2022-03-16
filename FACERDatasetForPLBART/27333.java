  @Override
  public final void bindToContentValues(ContentValues values,
      WeatherForecastData.ForecastList model) {
    values.put("`id`", model.getId());
    bindToInsertValues(values, model);
  }

