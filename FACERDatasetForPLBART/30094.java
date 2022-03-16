    public boolean isAlarmOff() {
        Intent intent = new Intent(mContext, mCls);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext,
                0,
                intent,
                PendingIntent.FLAG_NO_CREATE);
        return pendingIntent == null;
    }

