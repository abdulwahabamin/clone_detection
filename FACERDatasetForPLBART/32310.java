    protected void sendRetryMessageToCurrentWeatherService() {
        appendLog(getBaseContext(), TAG, "sendRetryMessageToCurrentWeatherService:1");
        currentWeatherServiceLock.lock();
        appendLog(getBaseContext(), TAG, "sendRetryMessageToCurrentWeatherService:after lock");
        try {
            Message msg = Message.obtain(
                    null,
                    CurrentWeatherService.START_CURRENT_WEATHER_RETRY
            );
            if (checkIfCurrentWeatherServiceIsNotBound()) {
                appendLog(getBaseContext(), TAG, "sendRetryMessageToCurrentWeatherService:pushing into messages");
                currentWeatherUnsentMessages.add(msg);
                return;
            }
            appendLog(getBaseContext(), TAG, "sendMessageToService:");
            currentWeatherService.send(msg);
            jobFinished(params, false);
        } catch (RemoteException e) {
            appendLog(getBaseContext(), TAG, e.getMessage(), e);
        } finally {
            currentWeatherServiceLock.unlock();
        }
    }

