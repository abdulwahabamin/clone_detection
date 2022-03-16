    public Observable<Void> deleteFavoriteCityWeatherById(final long id) {

        String whereClause = Db.CityWeatherTable.COLUMN_ID + " LIKE ?";

        return Observable.fromCallable(() -> {

            SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
            db.delete(Db.CityWeatherTable.TABLE_NAME, whereClause, new String[]{String.valueOf(id)});
            return null;
        });
    }

