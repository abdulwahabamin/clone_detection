    @Override
    public OrmWeather readEntity(Cursor cursor, int offset) {
        OrmWeather entity = new OrmWeather( //
            cursor.isNull(offset) ? null : cursor.getLong(offset), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // city_id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // city_name
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)), // dt
            cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4), // temp
            cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5), // temp_min
            cursor.isNull(offset + 6) ? null : cursor.getDouble(offset + 6), // temp_max
            cursor.isNull(offset + 7) ? null : cursor.getDouble(offset + 7), // pressure
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // humidity
            cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9), // clouds
            cursor.isNull(offset + 10) ? null : cursor.getDouble(offset + 10), // wind_speed
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // wind_dir
            cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12), // rain
            cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13), // snow
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // icon
            cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15), // condition_code
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // condition_text
            cursor.isNull(offset + 17) ? null : cursor.getShort(offset + 17) != 0 // is_day
        );
        return entity;
    }

