    public static PendingIntent getPendingIntentForVoice(Context context, Long voiceSettingId) {
        Intent sendIntent = new Intent("android.intent.action.SAY_WEATHER");
        sendIntent.setPackage("org.thosp.yourlocalweather");
        sendIntent.putExtra("voiceSettingId", voiceSettingId);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, sendIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);
        return pendingIntent;
    }

