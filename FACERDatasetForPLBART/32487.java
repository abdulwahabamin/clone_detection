    private void processSensorEvent(SensorEvent sensorEvent) {
        double countedLength;
        double countedAcc;
        long now = sensorEvent.timestamp;
        try {
            final float dT = (float) (now - lastUpdate) / 1000000000.0f;
            lastUpdate = now;

            if (lastMovement != null) {
                countedAcc = (float) Math.sqrt((lastMovement.getX() * lastMovement.getX()) + (lastMovement.getY() * lastMovement.getY()) + (lastMovement.getZ() * lastMovement.getZ()));
                countedLength = countedAcc * dT *dT;

                float lowPassConst = 0.1f;

                if ((countedAcc < lowPassConst) || (dT > 1000f)) {
                    if (dT > 1.0f) {
                        appendLogSensorsCheck(getBaseContext(),
                                              TAG,
                                  "acc under limit",
                                              currentLength,
                                              countedLength,
                                              countedAcc,
                                              dT);
                    }
                    currentLengthLowPassed += countedLength;
                    lastMovement = highPassFilter(sensorEvent);
                    return;
                }
                currentLength += countedLength;
            } else {
                countedLength = 0;
                countedAcc = 0;
            }
            lastMovement = highPassFilter(sensorEvent);

            if ((lastUpdate%1000 < 5) || (countedLength > 10)) {
                appendLogSensorsCheck(getBaseContext(), TAG, "current", currentLength, countedLength, countedAcc, dT);
            }
            float absCurrentLength = Math.abs(currentLength) * sensorResolutionMultiplayer;

            long lastUpdatedPosition = getLastPossitionUodateTime();
            long nowInMillis = System.currentTimeMillis();

            boolean nowIsBeforeTheLastUpdatedAndTimeSpan = (nowInMillis < (lastUpdatedPosition + ACCELEROMETER_UPDATE_TIME_SPAN));
            boolean currentLengthIsUnderLimit = (absCurrentLength < LENGTH_UPDATE_LOCATION_LIMIT);
            boolean nowIsBeforeTheLastUpdatedAndFastTimeSpan = (nowInMillis < (lastUpdatedPosition + ACCELEROMETER_UPDATE_TIME_SECOND_SPAN));
            boolean currentLengthIsUnderFastLimit = (absCurrentLength < LENGTH_UPDATE_LOCATION_SECOND_LIMIT);
            boolean nowIsBeforeTheLastUpdatedAndTimeSpanNoLocation = (nowInMillis < (lastUpdatedPosition + ACCELEROMETER_UPDATE_TIME_SPAN_NO_LOCATION));
            boolean currentLengthIsUnderNoLocationLimit = (absCurrentLength < LENGTH_UPDATE_LOCATION_LIMIT_NO_LOCATION);

            if (processLocationUpdate ||
                    (nowIsBeforeTheLastUpdatedAndTimeSpan || currentLengthIsUnderLimit)
                 && (nowIsBeforeTheLastUpdatedAndFastTimeSpan || currentLengthIsUnderFastLimit)
                 && (autolocationForSensorEventAddressFound || nowIsBeforeTheLastUpdatedAndTimeSpanNoLocation || currentLengthIsUnderNoLocationLimit)) {
                return;
            }
            processLocationUpdate = true;
            appendLogSensorsEnd(getBaseContext(),
                             TAG,
                             absCurrentLength,
                             currentLengthLowPassed,
                             nowInMillis,
                             lastUpdatedPosition,
                             nowIsBeforeTheLastUpdatedAndTimeSpan,
                             currentLengthIsUnderLimit,
                             nowIsBeforeTheLastUpdatedAndFastTimeSpan,
                             currentLengthIsUnderFastLimit,
                             autolocationForSensorEventAddressFound,
                             nowIsBeforeTheLastUpdatedAndTimeSpanNoLocation,
                             currentLengthIsUnderNoLocationLimit);
        } catch (Exception e) {
            appendLog(getBaseContext(), TAG, "Exception when processSensorQueue", e);
            processLocationUpdate = false;
            return;
        }

        if (!locationUpdateServiceActions.isEmpty()) {
            return;
        }

        clearMeasuredLength();

        if (!updateNetworkLocation()) {
            stopRefreshRotation("updateNetworkLocation", 3);
            sendMessageToWakeUpService(
                    AppWakeUpManager.FALL_DOWN,
                    AppWakeUpManager.SOURCE_LOCATION_UPDATE
            );
        }
    }

