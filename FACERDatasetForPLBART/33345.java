    @Override
    public void removeCityById(int cityId) {
        updateLastRequestedCityInfo(cityId);
        Intent intent = new Intent(this, GeneralDatabaseService.class);
        intent.setAction(GeneralDatabaseService.ACTION_DELETE_CITY_RECORDS);
        intent.putExtra(CITY_ID, cityId);
        startService(intent);
    }

