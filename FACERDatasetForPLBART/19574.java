    @Override
    public void onProgressUpdate(AsyncBuildLibraryTask task, String mCurrentTask, int overallProgress,
                                 int maxProgress, boolean mediaStoreTransferDone) {
        mBuilder = new NotificationCompat.Builder(mContext);
        mBuilder.setSmallIcon(R.drawable.notif_icon);
        mBuilder.setContentTitle(mCurrentTask);
        mBuilder.setTicker(mCurrentTask);
        mBuilder.setContentText("");
        mBuilder.setProgress(maxProgress, overallProgress, false);

        mNotifyManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotification = mBuilder.build();
        mNotification.flags |= Notification.FLAG_INSISTENT | Notification.FLAG_NO_CLEAR;
        mNotifyManager.notify(mNotificationId, mNotification);

    }

