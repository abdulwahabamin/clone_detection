    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int widgetId : appWidgetIds) {
            Log.i("In" , "New Widget Provider");
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                    R.layout.widget_small);

            Intent intent = new Intent(context, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                    0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.widget_button_refresh, pendingIntent);

            intent = new Intent(context, WeatherActivity.class);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            remoteViews.setOnClickPendingIntent(R.id.widget_root, pendingIntent);

            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            WeatherInfo weather;
            if(!sp.getString("lastToday", "").equals("")) {
                weather = parseWidgetJson(sp.getString("lastToday", ""));
            }
            else {
                try {
                    pendingIntent.send();
                } catch (PendingIntent.CanceledException e) {
                    e.printStackTrace();
                }
                return;
            }
            String temperatureScale = PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.PREF_TEMPERATURE_UNITS , Constants.METRIC).equals(Constants.METRIC) ? context.getString(R.string.c) : context.getString(R.string.f);
            String temperature = String.format(Locale.getDefault(), "%.0f", weather.getMain().getTemp());
            int iconId = weather.getWeather().get(0).getId();
            String weatherIcon = Utils.setWeatherIcon( context, iconId);

            remoteViews.setTextViewText(R.id.widget_city, weather.getName() + "," + weather.getSys().getCountry());
            remoteViews.setTextViewText(R.id.widget_temperature, temperature + temperatureScale);
            remoteViews.setImageViewBitmap(R.id.widget_icon,
                    Utils.createWeatherIcon(context, weatherIcon));

            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
        scheduleNextUpdate(context);
    }

