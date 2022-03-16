    public long insert(County county) {
        ContentValues values = new ContentValues();
        values.put(County.KEY_NAME, county.getName());
        values.put(County.KEY_NAME_EN, county.getNameEn());
        values.put(County.KEY_CITY, county.getCity());
        values.put(County.KEY_PROVINCE, county.getProvince());
        values.put(County.KEY_CODE, county.getCode());
        return mDatabase.insert(Consts.DATABASE_TABLE_COUNTY, null, values);
    }

