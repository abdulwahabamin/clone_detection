  @Override
  public final OperatorGroup getPrimaryConditionClause(WeatherData.Main model) {
    OperatorGroup clause = OperatorGroup.clause();
    clause.and(id.eq(model.getId()));
    return clause;
  }

