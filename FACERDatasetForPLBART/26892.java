    @Override
    protected final void bindValues(SQLiteStatement stmt, OrmWeather entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long city_id = entity.getCity_id();
        if (city_id != null) {
            stmt.bindLong(2, city_id);
        }
 
        String city_name = entity.getCity_name();
        if (city_name != null) {
            stmt.bindString(3, city_name);
        }
 
        java.util.Date dt = entity.getDt();
        if (dt != null) {
            stmt.bindLong(4, dt.getTime());
        }
 
        Double temp = entity.getTemp();
        if (temp != null) {
            stmt.bindDouble(5, temp);
        }
 
        Double temp_min = entity.getTemp_min();
        if (temp_min != null) {
            stmt.bindDouble(6, temp_min);
        }
 
        Double temp_max = entity.getTemp_max();
        if (temp_max != null) {
            stmt.bindDouble(7, temp_max);
        }
 
        Double pressure = entity.getPressure();
        if (pressure != null) {
            stmt.bindDouble(8, pressure);
        }
 
        Integer humidity = entity.getHumidity();
        if (humidity != null) {
            stmt.bindLong(9, humidity);
        }
 
        Integer clouds = entity.getClouds();
        if (clouds != null) {
            stmt.bindLong(10, clouds);
        }
 
        Double wind_speed = entity.getWind_speed();
        if (wind_speed != null) {
            stmt.bindDouble(11, wind_speed);
        }
 
        String wind_dir = entity.getWind_dir();
        if (wind_dir != null) {
            stmt.bindString(12, wind_dir);
        }
 
        Integer rain = entity.getRain();
        if (rain != null) {
            stmt.bindLong(13, rain);
        }
 
        Integer snow = entity.getSnow();
        if (snow != null) {
            stmt.bindLong(14, snow);
        }
 
        String icon = entity.getIcon();
        if (icon != null) {
            stmt.bindString(15, icon);
        }
 
        Integer condition_code = entity.getCondition_code();
        if (condition_code != null) {
            stmt.bindLong(16, condition_code);
        }
 
        String condition_text = entity.getCondition_text();
        if (condition_text != null) {
            stmt.bindString(17, condition_text);
        }
 
        Boolean is_day = entity.getIs_day();
        if (is_day != null) {
            stmt.bindLong(18, is_day ? 1L: 0L);
        }
    }

