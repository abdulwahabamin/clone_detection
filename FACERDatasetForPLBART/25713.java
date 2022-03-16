    private void updateWidget(Context context,AppWidgetManager appWidgetManager) {


        WeatherData weatherData = null;
        LiveData<StatusDataResource<WeatherData>> liveWeatherData = CoreManager.getImpl(IWeatherProvider.class).getWeatherData();
        if(liveWeatherData.getValue() !=null && liveWeatherData.getValue().isSucceed()) {
             weatherData = liveWeatherData.getValue().data;
        }

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.weather_widget_layout);

        if (weatherData == null) {
            return;
        }

        WeatherData.BasicEntity basic = weatherData.getBasic();
        remoteViews.setTextViewText(R.id.temp,basic.getTemp());
        remoteViews.setTextViewText(R.id.weather_status, basic.getWeather());
        remoteViews.setTextViewText(R.id.city, basic.getCity());
        remoteViews.setImageViewResource(R.id.status_icon, ResourceProvider.getIconId(basic.getWeather()));

        Intent newTaskIntent = new Intent(context, SplashActivity.class);
        newTaskIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, newTaskIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.widget_container, pIntent);
        appWidgetManager.updateAppWidget(new ComponentName(context, WeatherWidgetProvider.class), remoteViews);
    }

