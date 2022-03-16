    private void startWakeUp(Integer wakeUpSource) {
        wakeUpSourcesLock.lock();
        try {
            if (!wakeUpSources.contains(wakeUpSource)) {
                wakeUpSources.add(wakeUpSource);
            }
            appendLogWakeupSources(getBaseContext(), TAG, "startWakeUp:", wakeUpSources);
            if ((wakeLock != null) && wakeLock.isHeld()) {
                appendLog(getBaseContext(), TAG,"wakeUp started");
                return;
            }
            wakeUp();
            appendLog(getBaseContext(), TAG,"start wakeup");
        } catch (Exception e) {
            appendLog(getBaseContext(), TAG, "Exception starting wakeup", e);
        } finally {
            wakeUpSourcesLock.unlock();
        }
    }

