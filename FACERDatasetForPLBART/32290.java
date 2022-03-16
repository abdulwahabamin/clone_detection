    private void stopWakeUp(Integer wakeUpSource) {
        wakeUpSourcesLock.lock();
        try {
            if (wakeUpSources.contains(wakeUpSource)) {
                wakeUpSources.remove(wakeUpSource);
            }
            appendLogWakeupSources(getBaseContext(), TAG, "startWakeUp:", wakeUpSources);
            if (!wakeUpSources.isEmpty()) {
                return;
            }
            wakeDown();
        } catch (Exception e) {
            appendLog(getBaseContext(), TAG, "Exception stoping wakeup", e);
        } finally {
            wakeUpSourcesLock.unlock();
        }
    }

