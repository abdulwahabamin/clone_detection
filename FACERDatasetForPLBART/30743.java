    public Observable<List<CityWeather>> getAllFavoriteCityWeather() {

        String sqlQuery = "SELECT * FROM "
                + Db.CityWeatherTable.TABLE_NAME + " WHERE " + Db.CityWeatherTable.COLUMN_FAVORITE + "= ?";

        return Observable.fromCallable(() -> {

            SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
            return db.rawQuery(sqlQuery, new String[]{String.valueOf(1)});
        }).map(cursor -> {

            List<CityWeather> cityWeatherList = new ArrayList<>();

            if (cursor != null && cursor.moveToFirst()) {

                while (!cursor.isAfterLast()) {

                    cityWeatherList.add(Db.CityWeatherTable.parseCursor(cursor));
                    cursor.moveToNext();
                }

                cursor.close();
            }

            return cityWeatherList;
        });
    }

