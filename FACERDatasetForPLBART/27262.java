    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        SimpleDateFormat format = new SimpleDateFormat("EE, dd MMM, HH:mm", Locale.getDefault());
        PreferencesHelper pref = PreferencesHelper.getInstance();
        boolean isMetric = getString(R.string.pref_unit_default_value)
                .equals(pref.getUnits(this));
        if (intent != null  ) {
            boolean sync = intent.getIntExtra(WeatherService.EXTRA_KEY_SYNC, 0) == 1;
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
            final int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this,
                    TodayWidgetProvider.class));
            ILocalDataSource localDataSource = ((WeatherApp) getApplicationContext()).getLocalDataSource();
            if (localDataSource.getCityList() != null && !localDataSource.getCityList().isEmpty()) {
            OrmCity ormCity = localDataSource.getCityList().get(0);
            String cityName = null;
            String description = null;
            String date = null;
            String wind = null;
            String weatherIcon = null;
            String formatTemp = null;
            String formatTempMax = null;
            String formatTempMin = null;
            if (ormCity != null) {
                 cityName = ormCity.getCity_name();
                 OrmWeather ormWeather = localDataSource.getSingleForecast(ormCity.get_id());
                if (ormWeather != null) {
                     description = ormWeather.getCondition_text();
                     date = format.format(ormWeather.getDt());
                     wind = getString(R.string.format_wind, ormWeather.getWind_speed(),
                             isMetric?"m/s":"mph", ormWeather.getWind_dir());
                     weatherIcon = "http:" + ormWeather.getIcon();
                     formatTemp = getString(R.string.format_widget_temperature, ormWeather.getTemp(),isMetric?"°C":"°F");
                     formatTempMax = getString(R.string.format_widget_temperature, ormWeather.getTemp_max(),isMetric?"°C":"°F");
                     formatTempMin = getString(R.string.format_widget_temperature, ormWeather.getTemp_min(),isMetric?"°C":"°F");
                }
              }
            for (int appWidgetId : appWidgetIds) {
                int widgetWidth = getWidgetWidth(appWidgetManager, appWidgetId);
                int defaultWidth = getResources().getDimensionPixelSize(R.dimen.widget_today_default_width);
                int largeWidth = getResources().getDimensionPixelSize(R.dimen.widget_today_large_width);
                int layoutId;
                if (widgetWidth >= largeWidth) {
                    layoutId = R.layout.widget_today_large;
                } else if (widgetWidth >= defaultWidth) {
                    layoutId = R.layout.widget_today;
                } else {
                    layoutId = R.layout.widget_today_small;
                }
                final RemoteViews views = new RemoteViews(getPackageName(), layoutId);
                    //final RemoteViews views = new RemoteViews(getPackageName(), R.layout.widget_today_large);
                    views.setViewVisibility(R.id.widget_button_update, sync ? View.GONE : View.VISIBLE);
                    views.setViewVisibility(R.id.widget_progress_bar, sync ? View.VISIBLE : View.GONE);
                    setRemoteContentDescription(views, description);
                    if (wind!=null) views.setTextViewText(R.id.widget_wind, wind);
                    if (description!=null) views.setTextViewText(R.id.widget_description, description);
                    if (cityName!=null) views.setTextViewText(R.id.widget_city_name, cityName);
                    if (date!=null) views.setTextViewText(R.id.widget_weather_date, date);
                    if (formatTemp!=null) views.setTextViewText(R.id.widget_high_temperature, formatTemp);
                    if (formatTempMax!=null) views.setTextViewText(R.id.widget_max_temperature, formatTempMin);
                    if (formatTempMin!=null) views.setTextViewText(R.id.widget_low_temperature, formatTempMin);
                    if (weatherIcon != null) loadWeatherIcon(appWidgetManager, appWidgetId, views, weatherIcon);
                    // Create an Intent to launch CitiesActivity
                    Intent launchIntent = new Intent(this, CitiesActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, launchIntent, 0);
                    views.setOnClickPendingIntent(R.id.widget, pendingIntent);
                    // Create an Intent to Update weather
                    Intent updateIntent = new Intent(this.getApplicationContext(), TodayWidgetProvider.class);
                    updateIntent.setAction(ACTION_APPWIDGET_REFRESH);
                    updateIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
                    PendingIntent pendingUpdateIntent =
                            PendingIntent.getBroadcast(getApplicationContext(), 0, updateIntent,
                                    PendingIntent.FLAG_UPDATE_CURRENT);
                    views.setOnClickPendingIntent(R.id.widget_button_update, pendingUpdateIntent);
                    // Tell the AppWidgetManager to perform an update on the current app widget
                    appWidgetManager.updateAppWidget(appWidgetId, views);
                }
            }
       }
    }

