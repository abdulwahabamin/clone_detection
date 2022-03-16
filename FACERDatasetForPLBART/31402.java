    @Override
    public void renderData(WeatherEntity entity) {
        if (entity == null) {
            return;
        }

        mEntity = entity;

        ComponentName thisWidget = new ComponentName(mContext, WeatherAppWidget.class);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(mContext);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

        for (int i = 0; i < appWidgetIds.length; ++i) {
            int appWidgetId = appWidgetIds[i];
            RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.app_widget_layout);

            Intent intent = new Intent(mContext, SplashActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, intent, 0);
            views.setOnClickPendingIntent(R.id.ll_app_widget_root, pendingIntent);

            if (entity.getForecasts().size() > 0) {
                mDataDate = entity.getForecasts().get(0).getDate();
            }

            if (mDataDate != null && mDataDate.compareToIgnoreCase(StringUtil.getCurrentDateTime("yyyy-MM-dd")) != 0) {
                views.setTextColor(R.id.tv_app_widget_weather_desc, mContext.getApplicationContext().getResources().getColor(R.color.colorAirFour));
                views.setTextViewText(R.id.tv_app_widget_weather_desc, mContext.getApplicationContext().getString(R.string.data_out_of_date));
            } else {
                views.setTextColor(R.id.tv_app_widget_weather_desc, mContext.getApplicationContext().getResources().getColor(R.color.colorLightGray));
                views.setTextViewText(R.id.tv_app_widget_weather_desc, entity.getWeatherDescription());
            }
            views.setImageViewResource(R.id.iv_app_widget_weather_icon, getWeatherIconId(entity.getWeatherDescription()));
            views.setTextViewText(R.id.tv_app_widget_city_name, entity.getCityName());
            views.setTextViewText(R.id.tv_app_widget_temp, entity.getCurrentTemperature() + "℃");
            AirQulityRepresentation airQulityRepresentation = new AirQulityRepresentation();
            getAirQualityTypeAndColor(entity.getAirQulityIndex(), airQulityRepresentation);
            //views.setTextColor(R.id.tv_app_widget_air, airQulityRepresentation.getmAirQulityColorId());
            views.setTextViewText(R.id.tv_app_widget_air, airQulityRepresentation.getmAirQulityType());

            views.setTextViewText(R.id.tv_app_widget_time, StringUtil.getCurrentDateTime("HH:mm"));
            views.setTextViewText(R.id.tv_app_widget_dayofweek, StringUtil.getCurrentDateTime("EEEE"));
            views.setTextViewText(R.id.tv_app_widget_date, StringUtil.getCurrentDateTime("M月d日"));
            String[] dateAndTime = entity.getDataUpdateTime().split(" ");
            Date date = StringUtil.stringToDate("yyyy-MM-dd", dateAndTime[0]);
            views.setTextViewText(R.id.tv_app_widget_update_time, StringUtil.getFriendlyDateString(date, false) + " " + dateAndTime[1] + " �?�布");

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }

        LogUtil.e(TAG, "renderData");
    }

