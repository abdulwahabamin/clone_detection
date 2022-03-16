    /**
     * Resending of network location request helps to get response when:
     * - andoroid has wifi connection only
     * - and wifi connection is established when the screen is on only
     *
     * Therefore when user swtich the phone on the wifi connection is starting and
     * is not available at the moment. Updater has to wait to get wifi on and
     * try to get the location again.
     *
     * @param byLastLocationOnly - param to be resend for JobService
     * @param originalIntent - original intent for old API solution
     * @param attempts - number of attempts for JobService
     * @return true when we cannot continue with location discovery
     */
    private boolean resendRequestWhenNetworkNotAvailable(boolean byLastLocationOnly,
                                                         Intent originalIntent,
                                                         Integer attempts) {
        ConnectionDetector connectionDetector = new ConnectionDetector(this);
        if (connectionDetector.isNetworkAvailableAndConnected()) {
            return false;
        }
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());
        org.thosp.yourlocalweather.model.Location currentLocation = locationsDbHelper.getLocationByOrderId(0);

        int numberOfAttempts;
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            numberOfAttempts = attempts;
        } else if (originalIntent != null) {
            numberOfAttempts = originalIntent.getIntExtra("attempts", 0);
        } else {
            updateLocationInProcess = false;
            stopRefreshRotation("updateNetworkLocationByNetwork:1", 3);
            sendMessageToWakeUpService(
                    AppWakeUpManager.FALL_DOWN,
                    AppWakeUpManager.SOURCE_LOCATION_UPDATE
            );
            return true;
        }

        if (numberOfAttempts > 2) {
            locationsDbHelper.updateLocationSource(
                    currentLocation.getId(),
                    getString(R.string.location_weather_update_status_location_not_reachable));
            updateLocationInProcess = false;
            stopRefreshRotation("updateNetworkLocationByNetwork:2", 3);
            sendMessageToWakeUpService(
                    AppWakeUpManager.FALL_DOWN,
                    AppWakeUpManager.SOURCE_LOCATION_UPDATE
            );
            return true;
        }

        numberOfAttempts++;

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            PersistableBundle bundle = new PersistableBundle();
            bundle.putBoolean("byLastLocationOnly", byLastLocationOnly);
            bundle.putInt("attempts", numberOfAttempts);
            ComponentName serviceComponent = new ComponentName(this, LocationUpdateServiceRetryJob.class);
            JobInfo.Builder builder = new JobInfo.Builder(LocationUpdateServiceRetryJob.JOB_ID, serviceComponent);
            builder.setMinimumLatency(LOCATION_UPDATE_RESEND_INTERVAL_IN_MS); // wait at least
            builder.setOverrideDeadline(LOCATION_UPDATE_RESEND_INTERVAL_IN_MS + (5 * 1000)); // maximum delay
            builder.setExtras(bundle);
            JobScheduler jobScheduler = getSystemService(JobScheduler.class);
            jobScheduler.schedule(builder.build());
        } else {
            originalIntent.putExtra("attempts", numberOfAttempts);
            resendTheIntentInSeveralSeconds(LOCATION_UPDATE_RESEND_INTERVAL_IN_MS, originalIntent);
        }
        updateLocationInProcess = false;
        stopRefreshRotation("updateNetworkLocationByNetwork:2", 3);
        sendMessageToWakeUpService(
                AppWakeUpManager.FALL_DOWN,
                AppWakeUpManager.SOURCE_LOCATION_UPDATE
        );
        return true;
    }

