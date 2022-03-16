  @Override
  public final OperatorGroup getPrimaryConditionClause(WeatherData.Weather model) {
    OperatorGroup clause = OperatorGroup.clause();
    clause.and(wId.eq(model.getWId()));
    return clause;
  }

