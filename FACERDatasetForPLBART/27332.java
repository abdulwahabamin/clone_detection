  @Override
  public final void bindToInsertValues(ContentValues values,
      WeatherForecastData.ForecastList model) {
    values.put("`dt`", model.getDt());
    values.put("`dt_txt`", model.getDt_txt());
  }

