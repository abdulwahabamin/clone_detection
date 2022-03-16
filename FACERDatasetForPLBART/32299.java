    protected void sendMessageToWeatherByVoiceService(Context context) {
        weatherByVoiceServiceLock.lock();
        try {
            Message msg = Message.obtain(
                    null,
                    WeatherByVoiceService.START_VOICE_WEATHER_ALL,
                    new WeatherByVoiceRequestDataHolder(voiceSettingId)
            );
            if (checkIfWeatherByVoiceServiceIsNotBound(context)) {
                //appendLog(getBaseContext(), TAG, "WidgetIconService is still not bound");
                weatherByvOiceUnsentMessages.add(msg);
                return;
            }
            //appendLog(getBaseContext(), TAG, "sendMessageToService:");
            weatherByVoiceService.send(msg);
        } catch (RemoteException e) {
            appendLog(context, TAG, e.getMessage(), e);
        } finally {
            weatherByVoiceServiceLock.unlock();
        }
    }

