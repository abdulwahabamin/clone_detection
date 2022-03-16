    protected void sendMessageToCurrentWeatherService(Context context,
                                                      Location location,
                                                      String updateSource,
                                                      boolean forceUpdate,
                                                      boolean updateWeatherOnly) {
        currentWeatherServiceLock.lock();
        try {
            Message msg = Message.obtain(
                    null,
                    CurrentWeatherService.START_CURRENT_WEATHER_UPDATE,
                    new WeatherRequestDataHolder(location.getId(), updateSource, forceUpdate, updateWeatherOnly)
            );
            if (checkIfCurrentWeatherServiceIsNotBound(context)) {
                //appendLog(getBaseContext(), TAG, "WidgetIconService is still not bound");
                currentWeatherUnsentMessages.add(msg);
                return;
            }
            //appendLog(getBaseContext(), TAG, "sendMessageToService:");
            currentWeatherService.send(msg);
        } catch (RemoteException e) {
            appendLog(context, TAG, e.getMessage(), e);
        } finally {
            currentWeatherServiceLock.unlock();
        }
    }

