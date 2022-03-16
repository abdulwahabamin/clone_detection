    @Override
    public WeatherEntity readEntity(Cursor cursor, int offset) {
        WeatherEntity entity = new WeatherEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // cityName
            cursor.isNull(offset + 2) ? null : cursor.getBlob(offset + 2), // weather
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)) // updateTime
        );
        return entity;
    }

