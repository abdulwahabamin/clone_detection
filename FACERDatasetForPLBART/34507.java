    private void cursor2City(CityData city,Cursor c){
        city.city_id = c.getString(c.getColumnIndex(WeatherDatabaseHelper.CityColumns.CITY_ID));
        city.cityName = c.getString(c.getColumnIndex(WeatherDatabaseHelper.CityColumns.CITY_NAME));
        city.cityNamePinyin = c.getString(c.getColumnIndex(WeatherDatabaseHelper.CityColumns.CITY_NAME_PINYIN));
        city.cntyName = c.getString(c.getColumnIndex(WeatherDatabaseHelper.CityColumns.CNTY_NAME));
        city.lat = c.getString(c.getColumnIndex(WeatherDatabaseHelper.CityColumns.LAT));
        city.lon = c.getString(c.getColumnIndex(WeatherDatabaseHelper.CityColumns.LON));
        city.prov = c.getString(c.getColumnIndex(WeatherDatabaseHelper.CityColumns.PROV));
    }

