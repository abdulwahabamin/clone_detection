    @Override
    protected final void bindValues(SQLiteStatement stmt, WeatherEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String cityName = entity.getCityName();
        if (cityName != null) {
            stmt.bindString(2, cityName);
        }
 
        byte[] weather = entity.getWeather();
        if (weather != null) {
            stmt.bindBlob(3, weather);
        }
 
        java.util.Date updateTime = entity.getUpdateTime();
        if (updateTime != null) {
            stmt.bindLong(4, updateTime.getTime());
        }
    }

