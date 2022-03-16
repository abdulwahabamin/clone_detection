    public void startCurrentWeatherUpdate(long incommingMessageTimestamp) {
        appendLog(getBaseContext(), TAG, "startCurrentWeatherUpdate");
        final LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());

        appendLog(getBaseContext(),
                TAG,
                "currentWeatherUpdateMessages.size before peek = ", currentWeatherUpdateMessages);

        WeatherRequestDataHolder updateRequest = currentWeatherUpdateMessages.peek();

        appendLog(getBaseContext(),
                TAG,
                "currentWeatherUpdateMessages.size after peek = ", currentWeatherUpdateMessages);

        if ((updateRequest == null) || (updateRequest.getTimestamp() < incommingMessageTimestamp)) {
            if (updateRequest != null) {
                appendLog(getBaseContext(),
                        TAG,
                        "updateRequest is older than current");
                if (!gettingWeatherStarted) {
                    resendTheIntentInSeveralSeconds(1);
                }
            } else {
                appendLog(getBaseContext(),
                        TAG,
                        "updateRequest is null");
            }
            appendLog(getBaseContext(),
                    TAG,
                    "currentWeatherUpdateMessages.size when request is old or null = ", currentWeatherUpdateMessages);
            return;
        }

        Location locationToCheck = locationsDbHelper.getLocationById(updateRequest.getLocationId());
        appendLog(getBaseContext(), TAG, "currentLocation=" + locationToCheck + ", updateSource=" + updateRequest.getUpdateSource());
        if (locationToCheck == null) {
            appendLog(getBaseContext(),
                    TAG,
                    "current location is null");
            currentWeatherUpdateMessages.poll();
            appendLog(getBaseContext(),
                    TAG,
                    "currentWeatherUpdateMessages.size when current location is null = ", currentWeatherUpdateMessages);
            startCurrentWeatherUpdate(0);
            return;
        }

        CurrentWeatherDbHelper currentWeatherDbHelper = CurrentWeatherDbHelper.getInstance(getBaseContext());
        CurrentWeatherDbHelper.WeatherRecord weatherRecord = currentWeatherDbHelper.getWeather(locationToCheck.getId());

        long lastUpdateTimeInMilis = (weatherRecord != null)?weatherRecord.getLastUpdatedTime():0;
        long now = System.currentTimeMillis();

        long updatePeriodForLocation;
        if (locationToCheck.getOrderId() == 0) {
            String updateAutoPeriodStr = AppPreference.getLocationAutoUpdatePeriod(this);
            updatePeriodForLocation = Utils.intervalMillisForAlarm(updateAutoPeriodStr);
        } else {
            String updatePeriodStr = AppPreference.getLocationUpdatePeriod(this);
            updatePeriodForLocation = Utils.intervalMillisForAlarm(updatePeriodStr);
        }

        appendLog(this.getBaseContext(), TAG,
                "Current weather requested for location.orderId=",
                locationToCheck.getOrderId(),
                ", updatePeriodForLocation=",
                updatePeriodForLocation,
                ", now=",
                now,
                ", lastUpdateTimeInMilis=",
                lastUpdateTimeInMilis);

        if (!updateRequest.isForceUpdate() &&
                (now <= (lastUpdateTimeInMilis + updatePeriodForLocation) &&
                (updateRequest.getUpdateSource() == null))) {
            appendLog(getBaseContext(),
                    TAG,
                    "Current weather is recent enough");
            currentWeatherUpdateMessages.poll();
            sendMessageToReconciliationDbService(false);
            WidgetUtils.updateWidgets(this);
            startCurrentWeatherUpdate(0);
            return;
        }

        if (updateRequest.isUpdateWeatherOnly()) {
            locationsDbHelper.updateLocationSource(locationToCheck.getId(), getString(R.string.location_weather_update_status_update_started));
            locationToCheck = locationsDbHelper.getLocationById(locationToCheck.getId());
        }

        final Location currentLocation = locationToCheck;

        ConnectionDetector connectionDetector = new ConnectionDetector(this);
        boolean networkAvailableAndConnected = connectionDetector.isNetworkAvailableAndConnected();
        appendLog(getBaseContext(), TAG, "networkAvailableAndConnected=", networkAvailableAndConnected);
        if (!networkAvailableAndConnected) {
            int numberOfAttempts = updateRequest.getAttempts();
            appendLog(getBaseContext(), TAG, "numberOfAttempts=", numberOfAttempts);
            if (numberOfAttempts > 2) {
                locationsDbHelper.updateLocationSource(
                        currentLocation.getId(),
                        getString(R.string.location_weather_update_status_location_not_reachable));
                appendLog(getBaseContext(),
                        TAG,
                        "currentWeatherUpdateMessages.size when attempts is more than 2 = ",
                        currentWeatherUpdateMessages);
                sendResult(ACTION_WEATHER_UPDATE_FAIL, getBaseContext());
                return;
            }
            updateRequest.increaseAttempts();
            resendTheIntentInSeveralSeconds(20);
            return;
        }

        if (gettingWeatherStarted) {
            resendTheIntentInSeveralSeconds(10);
        }

        gettingWeatherStarted = true;
        timerHandler.postDelayed(timerRunnable, 20000);
        final Context context = this;
        appendLog(getBaseContext(), TAG, "startRefreshRotation");
        startRefreshRotation("START", 2);
        Handler mainHandler = new Handler(Looper.getMainLooper());
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                if (currentLocation == null) {
                    appendLog(context,
                            TAG,
                            "currentLocation is null");
                    return;
                }
                final String locale = currentLocation.getLocaleAbbrev();
                appendLog(context,
                        TAG,
                        "weather get params: latitude:",
                        currentLocation.getLatitude(),
                        ", longitude",
                        currentLocation.getLongitude());
                try {
                    sendMessageToWakeUpService(
                            AppWakeUpManager.WAKE_UP,
                            AppWakeUpManager.SOURCE_CURRENT_WEATHER
                    );
                    client.get(Utils.getWeatherForecastUrl(
                            context,
                            Constants.WEATHER_ENDPOINT,
                            currentLocation.getLatitude(),
                            currentLocation.getLongitude(),
                            "metric",
                            locale).toString(), null, new AsyncHttpResponseHandler() {

                        @Override
                        public void onStart() {
                            // called before request is started
                        }

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                            try {
                                String weatherRaw = new String(response);
                                appendLog(context, TAG, "weather got, result:", weatherRaw);

                                final String locale = currentLocation.getLocaleAbbrev();
                                Weather weather = WeatherJSONParser.getWeather(context, weatherRaw, locale);
                                timerHandler.removeCallbacksAndMessages(null);
                                saveWeatherAndSendResult(context, weather);
                            } catch (JSONException e) {
                                appendLog(context, TAG, "JSONException:", e);
                                sendResult(ACTION_WEATHER_UPDATE_FAIL, context);
                            }
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                            appendLog(context, TAG, "onFailure:", statusCode, ":currentLocation=", currentLocation);
                            timerHandler.removeCallbacksAndMessages(null);
                            if (currentLocation != null) {
                                final LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());
                                switch (statusCode) {
                                    case 401:
                                        locationsDbHelper.updateLastUpdatedAndLocationSource(currentLocation.getId(),
                                                System.currentTimeMillis(), getString(R.string.location_weather_update_status_access_expired));
                                        break;
                                    case 429:
                                        locationsDbHelper.updateLastUpdatedAndLocationSource(currentLocation.getId(),
                                                System.currentTimeMillis(), getString(R.string.location_weather_update_status_access_banned));
                                        break;
                                    default:
                                        locationsDbHelper.updateLastUpdatedAndLocationSource(currentLocation.getId(),
                                                System.currentTimeMillis(), getString(R.string.location_weather_update_status_location_only));
                                        break;
                                }
                            }
                            sendResult(ACTION_WEATHER_UPDATE_FAIL, context);
                        }

                        @Override
                        public void onRetry(int retryNo) {
                            // called when request is retried
                        }
                    });
                } catch (MalformedURLException mue) {
                    appendLog(context, TAG, "MalformedURLException:", mue);
                    sendResult(ACTION_WEATHER_UPDATE_FAIL, context);
                }
            }
        };
        mainHandler.post(myRunnable);
    }

