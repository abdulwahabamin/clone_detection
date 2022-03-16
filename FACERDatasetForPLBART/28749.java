    private void handleUpdateCurrentWeatherAction(Intent intent) {
        boolean skipUpdateInterval = intent.getBooleanExtra(SKIP_UPDATE_INTERVAL, false);

        long timestamp = 0;
        long systemTime = System.currentTimeMillis() / 1000;
        long updateInterval = 2*60*60;
        boolean shouldUpdate = false;

        if (!skipUpdateInterval) {
            updateInterval = Long.valueOf(prefManager.getString("pref_updateInterval", "2"))*60*60;

            List<CityToWatch> citiesToWatch = dbHelper.getAllCitiesToWatch();
            // check timestamp of the current weather .. if one of them is out of date.. update them all at once
            List<CurrentWeatherData> weather = dbHelper.getAllCurrentWeathers();

            for(CityToWatch city : citiesToWatch) {
                int cityId = city.getCityId();
                boolean foundId = false;
                for (CurrentWeatherData w : weather) {
                    if(w.getCity_id() == cityId) {

                        foundId = true;

                        timestamp = w.getTimestamp();
                        if (timestamp + updateInterval - systemTime <= 0) {
                            shouldUpdate = true;
                            break;
                        }
                    }
                }
                if(shouldUpdate || !foundId) {
                    shouldUpdate = true;
                    break;
                }
            }
        }

        if (skipUpdateInterval || shouldUpdate) {
            IHttpRequestForCityList currentWeatherRequest = new OwmHttpRequestForUpdatingCityList(getApplicationContext());
            List<CityToWatch> cityToWatches = dbHelper.getAllCitiesToWatch();
            currentWeatherRequest.perform(cityToWatches);
        }
    }

