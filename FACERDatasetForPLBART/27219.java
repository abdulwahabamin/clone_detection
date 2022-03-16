    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null ) {
            if (BuildConfig.DEBUG) Log.d(LOG_TAG, " Beginning network data synchronization ");
            PreferencesHelper pref = PreferencesHelper.getInstance();
            selectedLang = LocaleHelper.getLanguage(getApplicationContext());
            fileManager = FileManager.getInstance(getAssets());
            isMetric = getString(R.string.pref_unit_default_value)
                    .equals(pref.getUnits(this));
            updateSyncStatus(SYNC_START);
            if (Utility.isNetworkAvailable(getApplicationContext())) {
                localDataSource = ((WeatherApp) getApplicationContext()).getLocalDataSource();
                final OpenWeatherService service = WeatherApiClient.getClient().create(OpenWeatherService.class);
                List<OrmCity> cities = localDataSource.getCityList();
                if (cities != null && !cities.isEmpty()) {
                    localDataSource.deleteAllForecast();//delete old forecast data
                    for (OrmCity city : cities) {
                        getWeatherForCity(service, city);
                    }

                }
            } else    {
                Log.d(LOG_TAG, getString(R.string.no_internet));
                updateSyncStatus(SYNC_NO_INTERNET);
            }
            if (BuildConfig.DEBUG) Log.d(LOG_TAG, " End network data synchronization ");
            updateSyncStatus(SYNC_END);
        }
    }

