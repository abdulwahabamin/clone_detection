  @Override
  public final OperatorGroup getPrimaryConditionClause(WeatherForecastData.ForecastList model) {
    OperatorGroup clause = OperatorGroup.clause();
    clause.and(id.eq(model.getId()));
    return clause;
  }

