        @Override
        public void onReceive(Context context, Intent intent) {
            appendLog(getBaseContext(), TAG, "onReceive("+intent+")");

            if (!intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                return;
            }
             
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    appendLog(getBaseContext(), TAG, "Runnable executing.");
                    unregisterListener();
                    registerSensorListener();
                }
            };

            new Handler().postDelayed(runnable, SCREEN_OFF_RECEIVER_DELAY);
        }

