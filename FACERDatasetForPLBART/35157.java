    @Override
    public LoveCityEntity readEntity(Cursor cursor, int offset) {
        LoveCityEntity entity = new LoveCityEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // cityName
            cursor.getInt(offset + 2) // order
        );
        return entity;
    }

