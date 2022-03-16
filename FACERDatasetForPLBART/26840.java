    @Override
    protected final void bindValues(SQLiteStatement stmt, OrmCity entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
 
        String city_name = entity.getCity_name();
        if (city_name != null) {
            stmt.bindString(2, city_name);
        }
 
        String region = entity.getRegion();
        if (region != null) {
            stmt.bindString(3, region);
        }
 
        String country = entity.getCountry();
        if (country != null) {
            stmt.bindString(4, country);
        }
 
        Double lat = entity.getLat();
        if (lat != null) {
            stmt.bindDouble(5, lat);
        }
 
        Double lon = entity.getLon();
        if (lon != null) {
            stmt.bindDouble(6, lon);
        }
    }

