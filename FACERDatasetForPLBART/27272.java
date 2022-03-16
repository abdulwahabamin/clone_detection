    private static void createCityTable(Schema schema){
        Entity note= schema.addEntity("OrmCity");
        note.addLongProperty("_id").primaryKey();
        note.addStringProperty("city_name");
        note.addStringProperty("region");
        note.addStringProperty("country");
        note.addDoubleProperty("lat");
        note.addDoubleProperty("lon");
    }

