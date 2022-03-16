    public long insert(WeatherInfo info) {
        ContentValues values = new ContentValues();
        values.put(WeatherInfo.KEY_COUNTY_CODE, info.getCounty().getCode());
        values.put(WeatherInfo.KEY_JSON, info.getRawJSONString());
        values.put(WeatherInfo.KEY_UPDATED, info.getUpdateTimestamp());
        return mDatabase.insert(Consts.DATABASE_TABLE_WEATHER_INFO, null, values);
    }

