    private void weatherNotification(WeatherInfo weather) {
        Intent intent = new Intent(this, WeatherActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        String temperatureScale = PreferenceManager.getDefaultSharedPreferences(this).getString(Constants.PREF_TEMPERATURE_UNITS , Constants.METRIC).equals(Constants.METRIC) ? getString(R.string.c) : getString(R.string.f);
        String speedScale = PreferenceManager.getDefaultSharedPreferences(this).getString(Constants.PREF_TEMPERATURE_UNITS , Constants.METRIC).equals(Constants.METRIC) ? getString(R.string.mps) : getString(R.string.mph);

        String temperature = getString(R.string.temperature , getString(R.string.pref_temp_header) , weather.getMain().getTemp() , temperatureScale);
        String city = getString(R.string.city , weather.getName() + ", " + weather.getSys().getCountry());
        String wind = getString(R.string.wind_ , weather.getWind().getSpeed(), speedScale);
        String humidity = getString(R.string.humidity , weather.getMain().getHumidity());
        String pressure = getString(R.string.pressure, weather.getMain().getPressure());

        String data = city + "\n" + temperature + "\n" + wind + "\n" + humidity + "\n" + pressure;

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        assert notificationManager != null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String id = "w01", name = "Weather";
            int importance = NotificationManager.IMPORTANCE_MIN;
            String desc = "Enable Hourly Weather Notifications";

            NotificationChannel channel = new NotificationChannel(id, name, importance);
            channel.setDescription(desc);
            notificationManager.createNotificationChannel(channel);
            builder = new Notification.Builder(this , id);
        }
        else
            builder = new Notification.Builder(this);

        builder.setAutoCancel(false);
        builder.setContentTitle(Math.round(weather.getMain().getTemp()) + temperatureScale + " at " + weather.getName());
        builder.setContentText(data);
        builder.setStyle(new Notification.BigTextStyle().bigText(data));
        builder.setSmallIcon(R.drawable.ic_notification_icon);
        builder.setContentIntent(pendingIntent);
        if (Build.VERSION.SDK_INT >= 24)
            builder.setColor(Color.RED);
        Notification notification = builder.build();
        notificationManager.notify(0 , notification);
    }

