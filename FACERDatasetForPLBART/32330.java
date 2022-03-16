        @Override
        public void run() {

            if (!gettingWeatherStarted) {
                return;
            }
            sendResult(ACTION_WEATHER_UPDATE_FAIL, getBaseContext());
        }

