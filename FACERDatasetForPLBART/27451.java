  @Override
  public final OperatorGroup getPrimaryConditionClause(WeatherData model) {
    OperatorGroup clause = OperatorGroup.clause();
    clause.and(id.eq(model.getId()));
    return clause;
  }

