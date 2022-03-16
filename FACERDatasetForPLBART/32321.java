    private void weatherNotification(Long locationId, String updateSource) {
        String notificationPresence = AppPreference.getNotificationPresence(this);
        if ("permanent".equals(notificationPresence)) {
            NotificationUtils.weatherNotification(this, locationId);
        } else if ("on_lock_screen".equals(notificationPresence) && NotificationUtils.isScreenLocked(this)) {
            NotificationUtils.weatherNotification(this, locationId);
        } else if ((updateSource != null) && "NOTIFICATION".equals(updateSource)) {
            NotificationUtils.weatherNotification(this, locationId);
        }
        sendMessageToWakeUpService(
                AppWakeUpManager.FALL_DOWN,
                AppWakeUpManager.SOURCE_NOTIFICATION
        );
    }

