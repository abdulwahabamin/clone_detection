  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement,
      WeatherForecastData.Rain model) {
    statement.bindNumberOrNull(1, model.getId());
    statement.bindNumberOrNull(2, model.getDt());
    statement.bindDoubleOrNull(3, model.getRainCount());
    statement.bindNumberOrNull(4, model.getId());
  }

