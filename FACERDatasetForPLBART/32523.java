    private Location checkNotificationAndReturnLocationForNotification(Calendar now,
                                                                       boolean notificationEnabled,
                                                                       long notificationPeriodMillis,
                                                                       long lastNotificationTimeInMs) {
        if (!notificationEnabled) {
            return null;
        }
        Location currentLocation = getLocationForNotification();
        if (currentLocation == null) {
            return null;
        }
        if (now.getTimeInMillis() < (lastNotificationTimeInMs + notificationPeriodMillis)) {
            return null;
        }
        return currentLocation;
    }

