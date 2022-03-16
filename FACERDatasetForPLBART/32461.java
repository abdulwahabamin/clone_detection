        @Override
        public void onReceive(Context context, Intent intent) {
            appendLog(context, TAG, "receive intent: ", intent);
            try {
                processScreenOn(context);
            } catch (Exception e) {
                appendLog(getBaseContext(), TAG, "Exception occured during database update", e);
                screenOnRetryCounter = 0;
                timerScreenOnRetryHandler.postDelayed(timerScreenOnRetryRunnable, SCREEN_ON_RETRY_FIRST);
            }
        }

