    public int update(WeatherInfo info) {
        ContentValues values = new ContentValues();
        values.put(WeatherInfo.KEY_JSON, info.getRawJSONString());
        values.put(WeatherInfo.KEY_UPDATED, info.getUpdateTimestamp());
        return mDatabase.update(
                Consts.DATABASE_TABLE_WEATHER_INFO,
                values,
                WeatherInfo.KEY_COUNTY_CODE + " = ?",
                new String[]{info.getCounty().getCode()});
    }

