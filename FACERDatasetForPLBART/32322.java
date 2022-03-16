        @Override
        public void handleMessage(Message msg) {
            WeatherRequestDataHolder weatherRequestDataHolder = (WeatherRequestDataHolder) msg.obj;
            appendLog(getBaseContext(), TAG, "handleMessage:", msg.what, ":", weatherRequestDataHolder);
            appendLog(getBaseContext(),
                    TAG,
                    "currentWeatherUpdateMessages.size when adding new message = ", currentWeatherUpdateMessages);
            switch (msg.what) {
                case START_CURRENT_WEATHER_UPDATE:
                    if (!currentWeatherUpdateMessages.contains(weatherRequestDataHolder)) {
                        currentWeatherUpdateMessages.add(weatherRequestDataHolder);
                    }
                    startCurrentWeatherUpdate(weatherRequestDataHolder.getTimestamp());
                    break;
                case START_CURRENT_WEATHER_RETRY:
                    startCurrentWeatherUpdate(0);
                default:
                    super.handleMessage(msg);
            }
        }

