    private PendingIntent getPendingIntent(Class<?> cls) {
        Intent intent = new Intent(mContext, cls);
        intent.setAction(Constants.ACTION_FORCED_APPWIDGET_UPDATE);
        return PendingIntent.getBroadcast(mContext,
                                          0,
                                          intent,
                                          PendingIntent.FLAG_CANCEL_CURRENT);
    }

