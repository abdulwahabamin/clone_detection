        @Override
        public void handleMessage(Message msg) {
            WeatherByVoiceRequestDataHolder weatherRequestDataHolder = (WeatherByVoiceRequestDataHolder) msg.obj;
            appendLog(getBaseContext(), TAG, "handleMessage:", msg.what, ":", weatherRequestDataHolder);
            appendLog(getBaseContext(),
                    TAG,
                    "weatherByVoiceMessages.size when adding new message = ", weatherByVoiceMessages);
            switch (msg.what) {
                case START_VOICE_WEATHER_UPDATED:
                    if (!weatherByVoiceMessages.contains(weatherRequestDataHolder)) {
                        weatherByVoiceMessages.add(weatherRequestDataHolder);
                    }
                    startVoiceCommand(weatherRequestDataHolder.getTimestamp());
                    break;
                case START_VOICE_WEATHER_ALL:
                    if (!weatherByVoiceMessages.contains(weatherRequestDataHolder)) {
                        weatherByVoiceMessages.add(weatherRequestDataHolder);
                    }
                    startAllLocationsVoiceCommand(weatherRequestDataHolder.getTimestamp(), weatherRequestDataHolder.getVoiceSettingsId());
                default:
                    super.handleMessage(msg);
            }
        }

