    public void showNotification(String macAddress, String user_name, String data)
    {
        if (currentWindow.equals(macAddress))
        {
            return;
        }


        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int count=0;
        try {
            count=notify_count.get(macAddress);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        android.support.v4.app.NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(user_name)
                        .setContentText(data)
                        .setNumber(++count)
                        .setAutoCancel(true);

        notify_count.put(macAddress,count);
// Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, ChatActivity.class);
        resultIntent.putExtra(Constants.NAME,user_name);
        resultIntent.putExtra(Constants.MAC_ADDRESS,macAddress);
// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(ChatActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        mBuilder.setContentIntent(resultPendingIntent);

// mNotificationId is a unique integer your app uses to identify the
// notification. For example, to cancel the notification, you can pass its ID
// number to NotificationManager.cancel().
        int id=notify_id.get(macAddress);
        mNotificationManager.notify(id,mBuilder.build());
    }

