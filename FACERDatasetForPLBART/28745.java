    /**
     * Be careful, with using this. It can cause many calls to the API, because it wants to update everything if the update interval allows it.
     * @param intent
     */
    private void handleUpdateAll(Intent intent) {
        handleUpdateCurrentWeatherAction(intent);
        List<CityToWatch> cities = dbHelper.getAllCitiesToWatch();
        for(CityToWatch c : cities) {
            handleUpdateForecastAction(intent, c.getCityId());
        }
    }

