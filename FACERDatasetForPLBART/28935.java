    static void updateAppWidget(final Context context, final AppWidgetManager appWidgetManager,
                                final int appWidgetId) {

        //CharSequence widgetText = WeatherWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
        // Construct the RemoteViews object
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.weather_5day_widget);

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
                List<Forecast> forecastList = database.getForecastsByCityId(cityId);
                List<Forecast> weekForecastList = new ArrayList<>();
                Date now = new Date();

                for(Forecast fc : forecastList) {
                    if(fc.getForecastTime().after(now)) {
                        Calendar c = new GregorianCalendar();
                        c.setTime(fc.getForecastTime());
                        if (c.get(Calendar.HOUR_OF_DAY) == 12) {
                            weekForecastList.add(fc);
                        }
                    }
                }

                updateView(context, appWidgetManager, views, appWidgetId, weekForecastList, city);

                database.close();

                return null;
            }
        }.doInBackground(cityId);
    }

