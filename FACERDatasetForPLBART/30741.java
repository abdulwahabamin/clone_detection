    public Observable<CityWeather> findFavoriteCityWeatherById(final long id) {

        String sqlQuery = "SELECT * FROM "
                + Db.CityWeatherTable.TABLE_NAME + " WHERE " + Db.CityWeatherTable.COLUMN_ID + "= ? AND "
                + Db.CityWeatherTable.COLUMN_FAVORITE + "= ?";

        return Observable.fromCallable(() -> {

            SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
            return db.rawQuery(sqlQuery, new String[]{String.valueOf(id), "1"});
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

