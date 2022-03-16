        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MSG_WEATHER_UPDATE) {
                showError(getString(R.string.weather_updated));
                renderCityWeather((WeatherEntity)msg.getData().getParcelable(WeatherUpdateReceiver.WEATHER_ENTITY));
                return;
            }
            super.handleMessage(msg);
        }

