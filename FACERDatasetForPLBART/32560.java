    protected void sendRetryMessageToWeatherForecastService() {
        weatherForecastServiceLock.lock();
        try {
            Message msg = Message.obtain(
                    null,
                    ForecastWeatherService.START_WEATHER_FORECAST_RETRY
            );
            if (checkIfWeatherForecastServiceIsNotBound()) {
                weatherForecastUnsentMessages.add(msg);
                return;
            }
            weatherForecastService.send(msg);
            jobFinished(params, false);
        } catch (RemoteException e) {
            appendLog(getBaseContext(), TAG, e.getMessage(), e);
        } finally {
            weatherForecastServiceLock.unlock();
        }
    }

