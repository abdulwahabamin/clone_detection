    public WeatherInfo query(County county) {
        Cursor cursor = mDatabase.query(
                Consts.DATABASE_TABLE_WEATHER_INFO,
                new String[]{WeatherInfo.KEY_UPDATED, WeatherInfo.KEY_JSON},
                WeatherInfo.KEY_COUNTY_CODE + " = ?",
                new String[]{county.getCode()},
                null, null, null);
        WeatherInfo info = null;
        if (cursor.moveToFirst()) {
            info = new WeatherInfo();
            info.setCounty(county);
            info.setRawJSONString(cursor.getString(cursor.getColumnIndex(WeatherInfo.KEY_JSON)));
            info.setUpdateTimestamp(cursor.getLong(cursor.getColumnIndex(WeatherInfo.KEY_UPDATED)));
        }
        cursor.close();
        return WeatherInfoFetcher.parse(info);
    }

