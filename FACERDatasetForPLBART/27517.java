  public GeneratedDatabaseHolder() {
    typeConverters.put(Boolean.class, new BooleanConverter());
    typeConverters.put(Character.class, new CharConverter());
    typeConverters.put(BigDecimal.class, new BigDecimalConverter());
    typeConverters.put(BigInteger.class, new BigIntegerConverter());
    typeConverters.put(Date.class, new SqlDateConverter());
    typeConverters.put(Time.class, new SqlDateConverter());
    typeConverters.put(Timestamp.class, new SqlDateConverter());
    typeConverters.put(Calendar.class, new CalendarConverter());
    typeConverters.put(GregorianCalendar.class, new CalendarConverter());
    typeConverters.put(java.util.Date.class, new DateConverter());
    typeConverters.put(UUID.class, new UUIDConverter());
    new WeatherStreamDBWeatherStreamDB_Database(this);
  }

