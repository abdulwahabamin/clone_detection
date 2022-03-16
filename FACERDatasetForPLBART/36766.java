    public int delete(County county) {
        return mDatabase.delete(
                Consts.DATABASE_TABLE_WEATHER_INFO,
                WeatherInfo.KEY_COUNTY_CODE + " = ?",
                new String[]{county.getCode()});
    }

