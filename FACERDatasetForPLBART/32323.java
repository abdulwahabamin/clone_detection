    protected void sendMessageToWeatherByVoiceService(Location location,
                                                      Weather weather,
                                                      long now) {
        weatherByVoiceServiceLock.lock();
        try {
            Message msg = Message.obtain(
                    null,
                    WeatherByVoiceService.START_VOICE_WEATHER_UPDATED,
                    new WeatherByVoiceRequestDataHolder(location, weather, now)
            );
            if (checkIfWeatherByVoiceServiceIsNotBound()) {
                //appendLog(getBaseContext(), TAG, "WidgetIconService is still not bound");
                weatherByvOiceUnsentMessages.add(msg);
                return;
            }
            //appendLog(getBaseContext(), TAG, "sendMessageToService:");
            weatherByVoiceService.send(msg);
        } catch (RemoteException e) {
            appendLog(getBaseContext(), TAG, e.getMessage(), e);
        } finally {
            weatherByVoiceServiceLock.unlock();
        }
    }

