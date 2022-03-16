  @Override
  public final OperatorGroup getPrimaryConditionClause(LocationSearchHistory model) {
    OperatorGroup clause = OperatorGroup.clause();
    clause.and(id.eq(model.getId()));
    return clause;
  }

