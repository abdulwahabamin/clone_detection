    public static void appendLogSensorsEnd(Context context,
                                           String tag,
                                           float absCurrentLength,
                                           float currentLengthLowPassed,
                                           long nowInMillis,
                                           long lastUpdatedPosition,
                                           boolean nowIsBeforeTheLastUpdatedAndTimeSpan,
                                           boolean currentLengthIsUnderLimit,
                                           boolean nowIsBeforeTheLastUpdatedAndFastTimeSpan,
                                           boolean currentLengthIsUnderFastLimit,
                                           boolean autolocationForSensorEventAddressFound,
                                           boolean nowIsBeforeTheLastUpdatedAndTimeSpanNoLocation,
                                           boolean currentLengthIsUnderNoLocationLimit) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, "end currentLength = ", String.format("%.8f", absCurrentLength),
                ", currentLengthLowPassed = ", String.format("%.8f", currentLengthLowPassed),
                ", lastUpdate=", String.valueOf(nowInMillis), ", lastUpdatePosition=", String.valueOf(lastUpdatedPosition),
                ", nowIsBeforeTheLastUpdatedAndTimeSpan=", String.valueOf(nowIsBeforeTheLastUpdatedAndTimeSpan),
                ", currentLengthIsUnderLimit=", String.valueOf(currentLengthIsUnderLimit),
                ", nowIsBeforeTheLastUpdatedAndFastTimeSpan=", String.valueOf(nowIsBeforeTheLastUpdatedAndFastTimeSpan),
                ", currentLengthIsUnderFastLimit=", String.valueOf(currentLengthIsUnderFastLimit),
                ", autolocationForSensorEventAddressFound=", String.valueOf(autolocationForSensorEventAddressFound),
                ", nowIsBeforeTheLastUpdatedAndTimeSpanNoLocation=", String.valueOf(nowIsBeforeTheLastUpdatedAndTimeSpanNoLocation),
                ", currentLengthIsUnderNoLocationLimit=", String.valueOf(currentLengthIsUnderNoLocationLimit)
        );
    }

