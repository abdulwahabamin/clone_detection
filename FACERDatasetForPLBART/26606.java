    public void fire(){
        Intent notificationIntent = new Intent(this.context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this.context,
                99, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationManager nm = (NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE);

        Resources res = context.getResources();
        Notification.Builder builder = new Notification.Builder(this.context);

        builder.setContentIntent(contentIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(res, this.largeIcon))
                .setTicker(this.ticker)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle(this.title)
                .setContentText(this.descrion)
                // ???
                .setStyle(new Notification.BigTextStyle().bigText(this.descrion))
                .setVibrate(new long[]{100, 100, 100, 100})
                .setLights(Color.YELLOW, 1000, 1000);
        Notification n = builder.build();
        n.defaults = 0;
        n.ledARGB = Color.WHITE;
        nm.notify(99, n);
    }

