    private static void createWeatherTable(Schema schema){
        Entity note= schema.addEntity("OrmWeather");
        note.addIdProperty();
        note.addLongProperty("city_id");
        note.addStringProperty("city_name");
        note.addDateProperty("dt");
        note.addDoubleProperty("temp");
        note.addDoubleProperty("temp_min");
        note.addDoubleProperty("temp_max");
        note.addDoubleProperty("pressure");
        note.addIntProperty("humidity");
        note.addIntProperty("clouds");
        note.addDoubleProperty("wind_speed");
        note.addStringProperty("wind_dir");
        note.addIntProperty("rain");
        note.addIntProperty("snow");
        note.addStringProperty("icon");
        note.addIntProperty("condition_code");
        note.addStringProperty("condition_text");
        note.addBooleanProperty("is_day");
    }

