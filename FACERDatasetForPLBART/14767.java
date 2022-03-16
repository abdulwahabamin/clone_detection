    public void sendNotification(int songIndex){
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        int importance = NotificationManager.IMPORTANCE_HIGH;
        String channelName = "SpasChannel";
        final String CHANNEL_ID = "my_channel_01";
        int buildVersion = Build.VERSION.SDK_INT;


        if(buildVersion >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, channelName, importance);
            notificationChannel.setDescription("This is a notification!");
            notificationChannel.setLightColor(Color.CYAN);
            notificationManager.createNotificationChannel(notificationChannel);


            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setContentTitle(getPackageName())
                    .setContentText("This is testing notification!")
                    .setOngoing(true)
                    .setSmallIcon(R.drawable.megaman);

            notificationManager.notify(101, notificationBuilder.build());
        }else{
            NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext())
                    .setContentTitle(songList.get(songIndex).getName())
                    .setSmallIcon(R.drawable.megaman)
                    .setOngoing(true);

            Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);

            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                    notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            notification.setContentIntent(pendingIntent);
            notificationManager.notify(0, notification.build());
        }
    }

