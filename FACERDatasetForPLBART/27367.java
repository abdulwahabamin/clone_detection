  @Override
  public final Property getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch ((columnName)) {
      case "`id`":  {
        return id;
      }
      case "`humidity`":  {
        return humidity;
      }
      case "`pressure`":  {
        return pressure;
      }
      case "`temp_max`":  {
        return temp_max;
      }
      case "`temp_min`":  {
        return temp_min;
      }
      case "`temp`":  {
        return temp;
      }
      case "`sea_level`":  {
        return sea_level;
      }
      case "`grnd_level`":  {
        return grnd_level;
      }
      case "`temp_kf`":  {
        return temp_kf;
      }
      default: {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }

