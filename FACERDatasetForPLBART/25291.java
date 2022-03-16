    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    private NotificationCompat.Action generateAction(int icon, String intentAction) {
        Intent intent = new Intent(getApplicationContext(), MediaPlayerService.class);
        intent.setAction(intentAction);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 1, intent, 0);
        return new NotificationCompat.Action.Builder(icon, intentAction, pendingIntent).build();
    }

