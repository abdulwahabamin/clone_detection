    public County query(String code) {
        Cursor cursor = mDatabase.query(
                Consts.DATABASE_TABLE_COUNTY,
                new String[]{County.KEY_NAME, County.KEY_NAME_EN, County.KEY_CITY, County.KEY_PROVINCE, County.KEY_CODE},
                County.KEY_CODE + " = ?",
                new String[]{code},
                null, null, null);
        County county = null;
        if (cursor.moveToFirst()) {
            county = new County();
            county.setName(cursor.getString(cursor.getColumnIndex(County.KEY_NAME)));
            county.setNameEn(cursor.getString(cursor.getColumnIndex(County.KEY_NAME_EN)));
            county.setCity(cursor.getString(cursor.getColumnIndex(County.KEY_CITY)));
            county.setProvince(cursor.getString(cursor.getColumnIndex(County.KEY_PROVINCE)));
            county.setCode(cursor.getString(cursor.getColumnIndex(County.KEY_CODE)));
        }
        cursor.close();
        return county;
    }

