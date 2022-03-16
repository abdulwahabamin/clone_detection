    protected void sendMessageToWeatherForecastService(long locationId, String updateSource, boolean forceUpdate) {
        appendLog(this,
                  TAG,
                "going to check weather forecast");
        if (!ForecastUtil.shouldUpdateForecast(this, locationId)) {
            appendLog(this,
                    TAG,
                    "weather forecast is recent enough");
            return;
        }
        appendLog(this,
                TAG,
                "sending message to get weather forecast");
        weatherForecastServiceLock.lock();
        try {
            Message msg = Message.obtain(
                    null,
                    ForecastWeatherService.START_WEATHER_FORECAST_UPDATE,
                    new WeatherRequestDataHolder(locationId, updateSource, forceUpdate)
            );
            if (checkIfWeatherForecastServiceIsNotBound()) {
                //appendLog(getBaseContext(), TAG, "WidgetIconService is still not bound");
                weatherForecastUnsentMessages.add(msg);
                return;
            }
            //appendLog(getBaseContext(), TAG, "sendMessageToService:");
            weatherForecastService.send(msg);
        } catch (RemoteException e) {
            appendLog(getBaseContext(), TAG, e.getMessage(), e);
        } finally {
            weatherForecastServiceLock.unlock();
        }
    }

