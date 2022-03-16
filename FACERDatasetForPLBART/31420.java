    @Override
    public void renderData(WeatherEntity entity) {
        if (entity == null) {
            return;
        }

        mEntity = entity;

        if (mNotificationManager == null) {
            mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        }

        Intent intent = new Intent(this, SplashActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        RemoteViews views = new RemoteViews(getPackageName(), R.layout.app_notification_layout_small);
        RemoteViews bigViews = new RemoteViews(getPackageName(), R.layout.app_notification_layout_big);

        if (entity.getForecasts().size() > 0) {
            mDataDate = entity.getForecasts().get(0).getDate();
        }

        if (mDataDate != null && mDataDate.compareToIgnoreCase(StringUtil.getCurrentDateTime("yyyy-MM-dd")) != 0) {
            views.setTextColor(R.id.tv_app_notification_small_weather_desc, mContext.getApplicationContext().getResources().getColor(R.color.colorAirFour));
            views.setTextViewText(R.id.tv_app_notification_small_weather_desc, mContext.getApplicationContext().getString(R.string.data_out_of_date));
            bigViews.setTextColor(R.id.tv_app_notification_small_weather_desc, mContext.getApplicationContext().getResources().getColor(R.color.colorAirFour));
            bigViews.setTextViewText(R.id.tv_app_notification_small_weather_desc, mContext.getApplicationContext().getString(R.string.data_out_of_date));
        } else {
            views.setTextColor(R.id.tv_app_notification_small_weather_desc, mContext.getApplicationContext().getResources().getColor(R.color.colorLightGray));
            views.setTextViewText(R.id.tv_app_notification_small_weather_desc, entity.getWeatherDescription());
            bigViews.setTextColor(R.id.tv_app_notification_small_weather_desc, mContext.getApplicationContext().getResources().getColor(R.color.colorLightGray));
            bigViews.setTextViewText(R.id.tv_app_notification_small_weather_desc, entity.getWeatherDescription());
        }

        views.setImageViewResource(R.id.iv_app_notification_small_weather_icon, getWeatherIconId(entity.getWeatherDescription()));
        views.setTextViewText(R.id.tv_app_notification_small_temp, entity.getCurrentTemperature() + "℃");
        views.setTextViewText(R.id.tv_app_notification_small_city_name, entity.getCityName());
        if (entity.getForecasts().size() > 0)
            views.setTextViewText(R.id.tv_app_notification_small_temp_span, entity.getForecasts().get(0).getMinTemperature() + " ~ " + entity.getForecasts().get(0).getMaxTemperature() + "℃");
        views.setTextViewText(R.id.tv_app_notification_small_date, StringUtil.getCurrentDateTime("yyyy-MM-dd"));
        views.setTextViewText(R.id.tv_app_notification_small_dayofweek, StringUtil.getCurrentDateTime("EEEE"));
        String[] dateAndTime = entity.getDataUpdateTime().split(" ");
        Date date = StringUtil.stringToDate("yyyy-MM-dd", dateAndTime[0]);
        views.setTextViewText(R.id.tv_app_notification_small_update_time, StringUtil.getFriendlyDateString(date, false) + " " + dateAndTime[1] + " �?�布");
        views.setTextViewText(R.id.tv_app_notification_small_air_quality_index, entity.getAirQulityIndex());
        AirQulityRepresentation airQulityRepresentation = new AirQulityRepresentation();
        getAirQualityTypeAndColor(entity.getAirQulityIndex(), airQulityRepresentation);
        //views.setTextColor(R.id.tv_app_notification_small_air_quality_type, airQulityRepresentation.getmAirQulityColorId());
        views.setTextViewText(R.id.tv_app_notification_small_air_quality_type, airQulityRepresentation.getmAirQulityType());

        bigViews.setImageViewResource(R.id.iv_app_notification_small_weather_icon, getWeatherIconId(entity.getWeatherDescription()));
        bigViews.setTextViewText(R.id.tv_app_notification_small_temp, entity.getCurrentTemperature() + "℃");
        bigViews.setTextViewText(R.id.tv_app_notification_small_city_name, entity.getCityName());
        if (entity.getForecasts().size() > 0)
            bigViews.setTextViewText(R.id.tv_app_notification_small_temp_span, entity.getForecasts().get(0).getMinTemperature() + " ~ " + entity.getForecasts().get(0).getMaxTemperature() + "℃");
        bigViews.setTextViewText(R.id.tv_app_notification_small_date, StringUtil.getCurrentDateTime("yyyy-MM-dd"));
        bigViews.setTextViewText(R.id.tv_app_notification_small_dayofweek, StringUtil.getCurrentDateTime("EEEE"));
        bigViews.setTextViewText(R.id.tv_app_notification_small_update_time, StringUtil.getFriendlyDateString(date, false) + " " + dateAndTime[1] + " �?�布");
        bigViews.setTextViewText(R.id.tv_app_notification_small_air_quality_index, entity.getAirQulityIndex());
        //bigViews.setTextColor(R.id.tv_app_notification_small_air_quality_type, airQulityRepresentation.getmAirQulityColorId());
        bigViews.setTextViewText(R.id.tv_app_notification_small_air_quality_type, airQulityRepresentation.getmAirQulityType());

        if (entity.getForecasts().size() >= 3) {
            bigViews.setImageViewResource(R.id.iv_app_notification_big_forecast_icon1, getWeatherIconId(entity.getForecasts().get(0).getWeatherDescriptionDaytime()));
            Date date0 = StringUtil.stringToDate("yyyy-MM-dd", entity.getForecasts().get(0).getDate());
            bigViews.setTextViewText(R.id.tv_app_notification_big_forecast_date1, StringUtil.getFriendlyDateString(date0, true));
            bigViews.setTextViewText(R.id.tv_app_notification_big_forecast_temp1, entity.getForecasts().get(0).getMinTemperature() + " ~ " + entity.getForecasts().get(0).getMaxTemperature() + "℃");

            bigViews.setImageViewResource(R.id.iv_app_notification_big_forecast_icon2, getWeatherIconId(entity.getForecasts().get(1).getWeatherDescriptionDaytime()));
            Date date1 = StringUtil.stringToDate("yyyy-MM-dd", entity.getForecasts().get(1).getDate());
            bigViews.setTextViewText(R.id.tv_app_notification_big_forecast_date2, StringUtil.getFriendlyDateString(date1, true));
            bigViews.setTextViewText(R.id.tv_app_notification_big_forecast_temp2, entity.getForecasts().get(1).getMinTemperature() + " ~ " + entity.getForecasts().get(1).getMaxTemperature() + "℃");

            bigViews.setImageViewResource(R.id.iv_app_notification_big_forecast_icon3, getWeatherIconId(entity.getForecasts().get(2).getWeatherDescriptionDaytime()));
            Date date2 = StringUtil.stringToDate("yyyy-MM-dd", entity.getForecasts().get(2).getDate());
            bigViews.setTextViewText(R.id.tv_app_notification_big_forecast_date3, StringUtil.getFriendlyDateString(date2, true));
            bigViews.setTextViewText(R.id.tv_app_notification_big_forecast_temp3, entity.getForecasts().get(2).getMinTemperature() + " ~ " + entity.getForecasts().get(2).getMaxTemperature() + "℃");
        }

        Notification notification = null;
        if (mNotificationBuilder == null) {
            mNotificationBuilder = new NotificationCompat.Builder(this);
        }

        mNotificationBuilder.setSmallIcon(getWeatherIconId(entity.getWeatherDescription())).setPriority(Notification.PRIORITY_MAX);
        notification = mNotificationBuilder.build();
        notification.bigContentView = bigViews;
        notification.contentView = views;
        bigViews.setOnClickPendingIntent(R.id.ll_app_notification_big_root, pendingIntent);
        bigViews.setOnClickPendingIntent(R.id.ll_app_notification_small_root, pendingIntent);
        views.setOnClickPendingIntent(R.id.ll_app_notification_small_root, pendingIntent);

        //mNotificationManager.notify(1, notification);
        startForeground(1, notification);

        LogUtil.e(TAG, "renderData");
    }

