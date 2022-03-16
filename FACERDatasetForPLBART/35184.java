    @Override
    public void readEntity(Cursor cursor, WeatherEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCityName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setWeather(cursor.isNull(offset + 2) ? null : cursor.getBlob(offset + 2));
        entity.setUpdateTime(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
     }

