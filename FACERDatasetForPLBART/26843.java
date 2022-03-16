    @Override
    public void readEntity(Cursor cursor, OrmCity entity, int offset) {
        entity.set_id(cursor.isNull(offset) ? null : cursor.getLong(offset));
        entity.setCity_name(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setRegion(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCountry(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setLat(cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4));
        entity.setLon(cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5));
     }

