    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTableIfNotExists(connectionSource, AirQualityLive.class);
            TableUtils.createTableIfNotExists(connectionSource, WeatherForecast.class);
            TableUtils.createTableIfNotExists(connectionSource, LifeIndex.class);
            TableUtils.createTableIfNotExists(connectionSource, WeatherLive.class);
            TableUtils.createTableIfNotExists(connectionSource, Weather.class);

            String weatherTrigger = "CREATE TRIGGER trigger_delete AFTER DELETE " +
                    "ON Weather " +
                    "FOR EACH ROW " +
                    "BEGIN " +
                    "DELETE FROM AirQuality WHERE cityId = OLD.cityId; " +
                    "DELETE FROM WeatherLive WHERE cityId = OLD.cityId; " +
                    "DELETE FROM WeatherForecast WHERE cityId = OLD.cityId; " +
                    "DELETE FROM LifeIndex WHERE cityId = OLD.cityId; " +
                    "END;";
            database.execSQL(weatherTrigger);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

