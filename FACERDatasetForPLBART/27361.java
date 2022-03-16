  @Override
  public final boolean exists(LocationSearchHistory model, DatabaseWrapper wrapper) {
    return SQLite.selectCountOf()
    .from(LocationSearchHistory.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

