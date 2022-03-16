  @Override
  public final void bindToInsertValues(ContentValues values, WeatherForecastData model) {
    values.put("`id`", model.getId());
    values.put("`message`", model.getMessage());
    values.put("`cnt`", model.getCnt());
    values.put("`cod`", model.getCod());
    values.put("`dt`", model.getDt());
  }

