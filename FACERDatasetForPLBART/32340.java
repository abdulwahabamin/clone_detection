        @Override
        public void handleMessage(Message msg) {
            WeatherRequestDataHolder weatherRequestDataHolder = (WeatherRequestDataHolder) msg.obj;
            appendLog(getBaseContext(), TAG, "handleMessage:", msg.what, ":", weatherRequestDataHolder);
            switch (msg.what) {
                case START_WEATHER_FORECAST_UPDATE:
                    if (!weatherForecastUpdateMessages.contains(weatherRequestDataHolder)) {
                        weatherForecastUpdateMessages.add(weatherRequestDataHolder);
                    }
                    startWeatherForecastUpdate(weatherRequestDataHolder.getTimestamp());
                    break;
                case START_WEATHER_FORECAST_RETRY:
                    startWeatherForecastUpdate(0);
                    break;
                default:
                    super.handleMessage(msg);
            }
        }

