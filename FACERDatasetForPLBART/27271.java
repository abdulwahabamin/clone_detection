    public static void main(String[] args) {
        Schema schema = new Schema(SCHEMA_VERSION, DEFAULT_PACKAGE);
        createCityTable(schema);
        createWeatherTable(schema);
        try {
            new DaoGenerator().generateAll(schema, "app/src/main/java/");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

