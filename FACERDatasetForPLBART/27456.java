  @Override
  public final Property getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch ((columnName)) {
      case "`id`":  {
        return id;
      }
      case "`message`":  {
        return message;
      }
      case "`cnt`":  {
        return cnt;
      }
      case "`cod`":  {
        return cod;
      }
      case "`dt`":  {
        return dt;
      }
      default: {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }

