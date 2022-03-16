  @Override
  public final void bindToInsertValues(ContentValues values, WeatherData model) {
    values.put("`id`", model.getId());
    values.put("`dt`", model.getDt());
    values.put("`cod`", model.getCod());
    values.put("`visibility`", model.getVisibility());
    values.put("`name`", model.getName());
    values.put("`base`", model.getBase());
  }

