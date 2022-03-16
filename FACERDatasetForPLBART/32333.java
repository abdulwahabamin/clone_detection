    public void startWeatherForecastUpdate(long incommingMessageTimestamp) {
        final LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());
        WeatherRequestDataHolder updateRequest = weatherForecastUpdateMessages.peek();

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
            return;
        }
        final Location currentLocation = locationsDbHelper.getLocationById(updateRequest.getLocationId());
        appendLog(getBaseContext(), TAG, "currentLocation=", currentLocation, ", updateSource=", updateRequest.getUpdateSource());

        if (currentLocation == null) {
            appendLog(getBaseContext(),
                    TAG,
                    "current location is null");
            weatherForecastUpdateMessages.poll();
            startWeatherForecastUpdate(0);
            return;
        }

        if (!updateRequest.isForceUpdate() &&
                !ForecastUtil.shouldUpdateForecast(this, currentLocation.getId()) &&
            (updateRequest.getUpdateSource() == null)) {
            appendLog(getBaseContext(),
                    TAG,
                    "Weather forecast is recent enough");
            updateRequest = weatherForecastUpdateMessages.poll();
            updateResultInUI(this, ACTION_WEATHER_UPDATE_OK, updateRequest);
            startWeatherForecastUpdate(0);
            return;
        }

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
        startRefreshRotation("START", 1);
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
                            AppWakeUpManager.SOURCE_WEATHER_FORECAST
                    );
                    client.get(Utils.getWeatherForecastUrl(
                            context,
                            Constants.WEATHER_FORECAST_ENDPOINT,
                            currentLocation.getLatitude(),
                            currentLocation.getLongitude(),
                            "metric",
                            currentLocation.getLocaleAbbrev()).toString(), null, new AsyncHttpResponseHandler() {

                        @Override
                        public void onStart() {
                            // called before request is started
                        }

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] weatherForecastResponse) {
                            try {
                                String weatherForecastRaw = new String(weatherForecastResponse);
                                appendLog(context, TAG, "weather got, result:", weatherForecastRaw);

                                CompleteWeatherForecast completeWeatherForecast = WeatherJSONParser.getWeatherForecast(
                                        context,
                                        currentLocation.getId(),
                                        weatherForecastRaw);
                                timerHandler.removeCallbacksAndMessages(null);
                                saveWeatherAndSendResult(context, completeWeatherForecast);
                            } catch (JSONException e) {
                                appendLog(context, TAG, "JSONException:", e);
                                sendResult(ACTION_WEATHER_UPDATE_FAIL, context);
                            }
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                            appendLog(context, TAG, "onFailure:", statusCode);
                            timerHandler.removeCallbacksAndMessages(null);
                            if (statusCode == 401) {
                                locationsDbHelper.updateLastUpdatedAndLocationSource(currentLocation.getId(),
                                        System.currentTimeMillis(), "E");

                            } else if (statusCode == 429) {
                                locationsDbHelper.updateLastUpdatedAndLocationSource(currentLocation.getId(),
                                        System.currentTimeMillis(), "B");

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

