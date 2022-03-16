  @Override
  public final Property getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch ((columnName)) {
      case "`wId`":  {
        return wId;
      }
      case "`id`":  {
        return id;
      }
      case "`icon`":  {
        return icon;
      }
      case "`description`":  {
        return description;
      }
      case "`main`":  {
        return main;
      }
      default: {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }

