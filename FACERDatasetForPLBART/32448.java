    public void startWeatherCheck() {
        boolean isNotificationEnabled = AppPreference.isNotificationEnabled(getBaseContext());
        String updateAutoPeriodStr = AppPreference.getLocationAutoUpdatePeriod(getBaseContext());
        boolean updateBySensor = "0".equals(updateAutoPeriodStr);
        if (!isNotificationEnabled || updateBySensor) {
            return;
        }
        Location currentLocation = NotificationUtils.getLocationForNotification(this);
        if (currentLocation == null) {
            return;
        }
        sendMessageToCurrentWeatherService(currentLocation, "NOTIFICATION", AppWakeUpManager.SOURCE_NOTIFICATION, true, true);
    }

