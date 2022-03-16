  @Override
  public final OperatorGroup getPrimaryConditionClause(WeatherData.Sys model) {
    OperatorGroup clause = OperatorGroup.clause();
    clause.and(sysId.eq(model.getSysId()));
    return clause;
  }

