    @Override
    public OrmCity readEntity(Cursor cursor, int offset) {
        OrmCity entity = new OrmCity( //
            cursor.isNull(offset) ? null : cursor.getLong(offset), // _id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // city_name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // region
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // country
            cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4), // lat
            cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5) // lon
        );
        return entity;
    }

