    /**
     * Renames the specified city.
     *
     * @param cityId  OpenWeatherMap city ID
     * @param newName a new name for the city
     */
    private void renameCity(int cityId, String newName) {
        Intent intent = new Intent(this, GeneralDatabaseService.class);
        intent.setAction(GeneralDatabaseService.ACTION_RENAME_CITY);
        intent.putExtra(CITY_ID, cityId);
        intent.putExtra(CITY_NEW_NAME, newName);
        startService(intent);
    }

