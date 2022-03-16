  @Override
  public final void bindToInsertStatement(DatabaseStatement statement,
      WeatherForecastData.Rain model, int start) {
    statement.bindNumberOrNull(1 + start, model.getDt());
    statement.bindDoubleOrNull(2 + start, model.getRainCount());
  }

