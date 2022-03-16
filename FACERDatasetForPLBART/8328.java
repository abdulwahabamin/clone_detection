        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().compareTo(
                    FileManagerSettings.INTENT_MOUNT_STATUS_CHANGED) == 0) {
                updatePreferences();
            }
        }

