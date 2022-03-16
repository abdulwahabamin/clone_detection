        public static ContentValues toContentValues(CityWeather cityWeather) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ID, cityWeather.getId());
            values.put(COLUMN_FAVORITE, cityWeather.isFavorite() ? 1 : 0);
            return values;
        }

