  @Override
  public final Property getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch ((columnName)) {
      case "`id`":  {
        return id;
      }
      case "`dt`":  {
        return dt;
      }
      case "`cod`":  {
        return cod;
      }
      case "`visibility`":  {
        return visibility;
      }
      case "`name`":  {
        return name;
      }
      case "`base`":  {
        return base;
      }
      default: {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }

