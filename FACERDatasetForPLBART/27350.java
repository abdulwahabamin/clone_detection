  @Override
  public final Property getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch ((columnName)) {
      case "`id`":  {
        return id;
      }
      case "`cityName`":  {
        return cityName;
      }
      case "`countyName`":  {
        return countyName;
      }
      case "`weatherType`":  {
        return weatherType;
      }
      case "`temperature`":  {
        return temperature;
      }
      case "`lat`":  {
        return lat;
      }
      case "`lon`":  {
        return lon;
      }
      default: {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }

