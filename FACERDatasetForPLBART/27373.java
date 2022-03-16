  @Override
  public final void bindToInsertValues(ContentValues values, WeatherData.Main model) {
    values.put("`humidity`", model.getHumidity());
    values.put("`pressure`", model.getPressure());
    values.put("`temp_max`", model.getTemp_max());
    values.put("`temp_min`", model.getTemp_min());
    values.put("`temp`", model.getTemp());
    values.put("`sea_level`", model.getSea_level());
    values.put("`grnd_level`", model.getGrnd_level());
    values.put("`temp_kf`", model.getTemp_kf());
  }

