  @Override
  public final OperatorGroup getPrimaryConditionClause(WeatherData.Wind model) {
    OperatorGroup clause = OperatorGroup.clause();
    clause.and(id.eq(model.getId()));
    return clause;
  }

