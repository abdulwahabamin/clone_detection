    @Override
    protected final void bindValues(SQLiteStatement stmt, LoveCityEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String cityName = entity.getCityName();
        if (cityName != null) {
            stmt.bindString(2, cityName);
        }
        stmt.bindLong(3, entity.getOrder());
    }

