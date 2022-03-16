    @Override
    public CityEntity readEntity(Cursor cursor, int offset) {
        CityEntity entity = new CityEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // cityName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // provinceName
        );
        return entity;
    }

