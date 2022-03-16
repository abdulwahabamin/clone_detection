    public void wakeDown() {
        timerWakeUpHandler.removeCallbacksAndMessages(null);
        appendLog(getBaseContext(), TAG, "wakeDown wakeLock:", wakeLock);
        if ((wakeLock != null) && wakeLock.isHeld()) {
            try {
                wakeLock.release();
                appendLog(getBaseContext(), TAG, "wakeLock released");
            } catch (Throwable th) {
                // ignoring this exception, probably wakeLock was already released
            }
        }
    }

