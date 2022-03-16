    private PendingIntent getPendingIntent(Class<?> cls) {
        Intent intent = new Intent(mContext, cls);
        return PendingIntent.getBroadcast(mContext,
                0,
                intent,
                PendingIntent.FLAG_CANCEL_CURRENT);
    }

