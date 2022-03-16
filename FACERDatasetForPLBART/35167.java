    @Override
    protected final void bindValues(DatabaseStatement stmt, ProvinceEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String provinceName = entity.getProvinceName();
        if (provinceName != null) {
            stmt.bindString(2, provinceName);
        }
    }

