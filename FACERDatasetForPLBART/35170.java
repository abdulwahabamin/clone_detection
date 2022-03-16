    @Override
    public ProvinceEntity readEntity(Cursor cursor, int offset) {
        ProvinceEntity entity = new ProvinceEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // provinceName
        );
        return entity;
    }

