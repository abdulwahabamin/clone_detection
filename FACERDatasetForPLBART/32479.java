        @Override
        public void onReceive(Context context, Intent intent) {
            appendLog(context, TAG, "onReceive start:", intent);
            if (networkIsOffline()) {
                wasOffline = true;
                return;
            }
            if (wasOffline) {
                checkAndUpdateWeather();
            }
            wasOffline = false;
        }

