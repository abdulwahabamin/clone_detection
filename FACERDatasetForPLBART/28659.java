    /**
     * Fill TABLE_CITIES_TO_WATCH with all the Cities
     */
    private synchronized void fillCityDatabase(SQLiteDatabase db) {
        long startInsertTime = System.currentTimeMillis();

        InputStream inputStream = context.getResources().openRawResource(R.raw.city_list);
        try {
            FileReader fileReader = new FileReader();
            final List<City> cities = fileReader.readCitiesFromFile(inputStream);
            addCities(db, cities);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endInsertTime = System.currentTimeMillis();
        Log.d("debug_info", "Time for insert:" + String.valueOf(endInsertTime - startInsertTime));
    }

