    private void startRotatingUpdateIcon(Integer rotationSource) {
        //appendLog(getBaseContext(), TAG, "startRotatingUpdateIcon:" + rotationSource);
        rotationSourcesLock.lock();
        try {
            if (!rotationSources.contains(rotationSource)) {
                rotationSources.add(rotationSource);
            }
            printRotationSources();
            if (WidgetRefreshIconService.isRotationActive) {
                appendLog(getBaseContext(), TAG,
                        "startRotatingUpdateIcon:endOnCondition:isRotationActive=",
                                WidgetRefreshIconService.isRotationActive, ":isThereRotationSchedule=");
                return;
            }
            WidgetRefreshIconService.isRotationActive = true;
            rotateRefreshButtonOneStep();
            appendLog(getBaseContext(), TAG,
                    "startRotatingUpdateIcon:setIsRotationActive=",
                            WidgetRefreshIconService.isRotationActive, ":postingNewSchedule");
            timerRotateIconHandler.postDelayed(timerRotateIconRunnable, ROTATE_UPDATE_ICON_MILIS);
        } catch (Exception e) {
            appendLog(getBaseContext(), TAG, "Exception storting rotation:", e);
        } finally {
            rotationSourcesLock.unlock();
        }
    }

