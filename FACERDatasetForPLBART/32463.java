        @Override
        public void run() {
            try {
                processScreenOn(getBaseContext());
            } catch (Exception e) {
                appendLog(getBaseContext(), TAG, "Exception occured during database update", e);
                if (screenOnRetryCounter < 3) {
                    screenOnRetryCounter++;
                    timerScreenOnRetryHandler.postDelayed(timerScreenOnRetryRunnable, SCREEN_ON_RETRY_NEXT);
                }
            }
        }

