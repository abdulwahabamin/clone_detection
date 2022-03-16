    private void stopRotatingUpdateIcon(Integer rotationSource) {
        //appendLog(getBaseContext(), TAG, "stopRotatingUpdateIcon:" + rotationSource);
        rotationSourcesLock.lock();
        try {
            //appendLog(getBaseContext(), TAG, "stopRotatingUpdateIcon:rotationSources.contains(rotationSource):" + rotationSources.contains(rotationSource));
            if (rotationSources.contains(rotationSource)) {
                rotationSources.remove(rotationSource);
            }
            printRotationSources();
            if (!rotationSources.isEmpty()) {
                return;
            }
            WidgetRefreshIconService.isRotationActive = false;
            appendLog(getBaseContext(), TAG,
                    "stopRotatingUpdateIcon:setIsRotationActive=",
                            WidgetRefreshIconService.isRotationActive, ":postingNewSchedule");
            timerRotateIconHandler.removeCallbacksAndMessages(null);
            WidgetUtils.updateWidgets(getBaseContext());
        } catch (Exception e) {
            appendLog(getBaseContext(), TAG, "Exception stoping rotation:", e);
        } finally {
            rotationSourcesLock.unlock();
        }
    }

