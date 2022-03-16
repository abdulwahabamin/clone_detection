    public Observable<CityWeather> findCityWeatherById(final long id) {

        String sqlQuery = "SELECT * FROM "
                + Db.CityWeatherTable.TABLE_NAME + " WHERE " + Db.CityWeatherTable.COLUMN_ID + "= ?";

        return Observable.fromCallable(() -> {

            SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
            return db.rawQuery(sqlQuery, new String[]{String.valueOf(id)});
        })
                .map((cursor) -> {

                    CityWeather cityWeather = null;

                    if (cursor != null && cursor.moveToFirst()) {
                        cityWeather = Db.CityWeatherTable.parseCursor(cursor);
                        cursor.close();
                    }

                    return cityWeather;
                });
    }

