  @Override
  public final OperatorGroup getPrimaryConditionClause(WeatherForecastData.Rain model) {
    OperatorGroup clause = OperatorGroup.clause();
    clause.and(id.eq(model.getId()));
    return clause;
  }

