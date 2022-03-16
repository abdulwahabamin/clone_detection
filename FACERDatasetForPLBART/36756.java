    public List<County> queryAll() {
        Cursor cursor = mDatabase.query(
                Consts.DATABASE_TABLE_COUNTY,
                new String[]{County.KEY_NAME, County.KEY_NAME_EN, County.KEY_CITY, County.KEY_PROVINCE, County.KEY_CODE},
                null, null, null, null, null);
        List<County> countyList = new ArrayList<>();
        while (cursor.moveToNext()) {
            County county = new County();
            county.setName(cursor.getString(cursor.getColumnIndex(County.KEY_NAME)));
            county.setNameEn(cursor.getString(cursor.getColumnIndex(County.KEY_NAME_EN)));
            county.setCity(cursor.getString(cursor.getColumnIndex(County.KEY_CITY)));
            county.setProvince(cursor.getString(cursor.getColumnIndex(County.KEY_PROVINCE)));
            county.setCode(cursor.getString(cursor.getColumnIndex(County.KEY_CODE)));
            countyList.add(county);
        }
        cursor.close();
        return countyList;
    }

