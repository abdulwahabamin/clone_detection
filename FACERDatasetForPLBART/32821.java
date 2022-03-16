    public static void weatherNotification(Context context, Long locationId) {
        String updateAutoPeriodStr = AppPreference.getLocationAutoUpdatePeriod(context);
        boolean updateBySensor = "0".equals(updateAutoPeriodStr);
        if (updateBySensor) {
            return;
        }
        Notification notification = getWeatherNotification(context, locationId);
        if (notification == null) {
            return;
        }
        showNotification(context, notification);
    }

