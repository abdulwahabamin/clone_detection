    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_BOOT_COMPLETED.equals(action)) {
            scheduleCleanup(this);
        } else if (ACTION_START.equals(action)) {
            cleanupOperation();
        }
    }

