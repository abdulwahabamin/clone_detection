  @Override
  public final Property getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch ((columnName)) {
      case "`sysId`":  {
        return sysId;
      }
      case "`message`":  {
        return message;
      }
      case "`id`":  {
        return id;
      }
      case "`sunset`":  {
        return sunset;
      }
      case "`sunrise`":  {
        return sunrise;
      }
      case "`type`":  {
        return type;
      }
      case "`country`":  {
        return country;
      }
      case "`pod`":  {
        return pod;
      }
      default: {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }

