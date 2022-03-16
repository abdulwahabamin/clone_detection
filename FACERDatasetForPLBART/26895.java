    @Override
    public void readEntity(Cursor cursor, OrmWeather entity, int offset) {
        entity.setId(cursor.isNull(offset) ? null : cursor.getLong(offset));
        entity.setCity_id(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setCity_name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDt(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
        entity.setTemp(cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4));
        entity.setTemp_min(cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5));
        entity.setTemp_max(cursor.isNull(offset + 6) ? null : cursor.getDouble(offset + 6));
        entity.setPressure(cursor.isNull(offset + 7) ? null : cursor.getDouble(offset + 7));
        entity.setHumidity(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
        entity.setClouds(cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9));
        entity.setWind_speed(cursor.isNull(offset + 10) ? null : cursor.getDouble(offset + 10));
        entity.setWind_dir(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setRain(cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12));
        entity.setSnow(cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13));
        entity.setIcon(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setCondition_code(cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15));
        entity.setCondition_text(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setIs_day(cursor.isNull(offset + 17) ? null : cursor.getShort(offset + 17) != 0);
     }

