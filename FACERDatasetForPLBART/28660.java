    private synchronized void addCities(SQLiteDatabase database, final List<City> cities) {
        if (cities.size() > 0) {

            //############################################
            // construct everything into one statement
//            StringBuilder sb = new StringBuilder();
//            sb.append("INSERT INTO ").append(TABLE_CITIES).append(" VALUES ");
//
//            for (int i = 0; i < cities.size(); i++) {
//                sb.append("(")
//                        .append(cities.get(i).getCityId()).append(", ")
//                        .append(cities.get(i).getCityName()).append(", ")
//                        .append(cities.get(i).getCountryCode()).append(", ")
//                        .append(cities.get(i).getPostalCode()).append(")");
//                if(i < cities.size() - 1) {
//                    sb.append(", ");
//                }
//            }
//            String sql = sb.toString();
//            database.rawQuery(sql, new String[]{});
            //############################################
            for (City c : cities) {
                ContentValues values = new ContentValues();
                values.put(CITIES_ID, c.getCityId());
                values.put(CITIES_NAME, c.getCityName());
                values.put(CITIES_COUNTRY_CODE, c.getCountryCode());
                values.put(CITIES_POSTAL_CODE, c.getPostalCode());
                database.insert(TABLE_CITIES, null, values);
            }
        }
    }

