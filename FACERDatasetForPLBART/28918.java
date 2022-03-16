    static void updateAppWidget(final Context context, final AppWidgetManager appWidgetManager,
                                final int appWidgetId) {

        //CharSequence widgetText = WeatherWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
        // Construct the RemoteViews object
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.weather_widget);

        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        final Integer cityId = prefs.getInt(PREF_PREFIX_KEY + appWidgetId, -1);
        if (cityId == -1) {
            Toast.makeText(context, "cityId is null?", Toast.LENGTH_LONG);
            return;
        }

        new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... params) {
                PFASQLiteHelper database = PFASQLiteHelper.getInstance(context);
                City city = database.getCityById(cityId);
                CurrentWeatherData weatherData = database.getCurrentWeatherByCityId(city.getCityId());

                updateView(context, appWidgetManager, views, appWidgetId, city, weatherData);

                database.close();

                return null;
            }
        }.doInBackground(cityId);
    }

