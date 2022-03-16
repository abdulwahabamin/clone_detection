        public static CityWeather parseCursor(@NonNull Cursor cursor) {

            CityWeather cityWeather = new CityWeather();
            cityWeather.setId(Long.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ID))));
            cityWeather.setFavorite(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_FAVORITE)) == 1);
            return cityWeather;
        }

