    public Observable<Void> addCityWeatherToDb(final CityWeather cityWeather) {

        return Observable.fromCallable(() -> {

            SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
            db.insert(Db.CityWeatherTable.TABLE_NAME, null, Db.CityWeatherTable.toContentValues(cityWeather));
            return null;
        });
    }

