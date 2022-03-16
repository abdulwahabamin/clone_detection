    public void wakeUp() {
        appendLog(getBaseContext(), TAG, "powerManager:", powerManager);

        boolean isInUse;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            isInUse = powerManager.isInteractive();
        } else {
            isInUse = powerManager.isScreenOn();
        }

        if (isInUse || ((wakeLock != null) && wakeLock.isHeld())) {
            appendLog(getBaseContext(), TAG, "lock is held");
            return;
        }

        timerWakeUpHandler.postDelayed(timerWakeUpRunnable, WAKEUP_TIMEOUT_IN_MS);

        String wakeUpStrategy = PreferenceManager.getDefaultSharedPreferences(getBaseContext())
                .getString(Constants.KEY_WAKE_UP_STRATEGY, "nowakeup");
        appendLog(getBaseContext(), TAG, "wakeLock:wakeUpStrategy:", wakeUpStrategy);
        if (wakeLock != null) {
            try {
                wakeLock.release();
            } catch (Throwable th) {
                // ignoring this exception, probably wakeLock was already released
            }
        }
        if ("nowakeup".equals(wakeUpStrategy)) {
            return;
        }
        int powerLockID;
        if ("wakeupfull".equals(wakeUpStrategy)) {
            powerLockID = PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP;
        } else {
            powerLockID = PowerManager.PARTIAL_WAKE_LOCK;
        }
        appendLog(getBaseContext(), TAG, "wakeLock:powerLockID:", powerLockID);
        wakeLock = powerManager.newWakeLock(powerLockID, "YourLocalWeather:PowerLock");
        appendLog(getBaseContext(), TAG, "wakeLock:", wakeLock, ":", wakeLock.isHeld());
        if (!wakeLock.isHeld()) {
            wakeLock.acquire();
        }
        appendLog(getBaseContext(), TAG, "wakeLock acquired");
    }

