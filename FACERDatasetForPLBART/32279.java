    private static PendingIntent getPendingScreenStartIntent(Context context) {
        Intent sendIntent = new Intent("android.intent.action.START_SCREEN_BASED_UPDATES");
        sendIntent.setPackage("org.thosp.yourlocalweather");
        return PendingIntent.getService(context,
                0,
                sendIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);
    }

