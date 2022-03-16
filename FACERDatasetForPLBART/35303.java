    private void updateAllAppWidgets(Context context, AppWidgetManager appWidgetManager, Set set) {

        // widget 的id
        int appID;
        // 迭代器，用于�??历所有�?存的widget的id
        Iterator it = set.iterator();

        while (it.hasNext()) {
            appID = ((Integer) it.next()).intValue();
            // 获�?� example_appwidget.xml 对应的RemoteViews
            String cityName = WeatherJsonConverter.getWeather(getCityData()).getBasic().getCity();
            String temp = WeatherJsonConverter.getWeather(getCityData()).getNow().getTmp();
            String cond = WeatherJsonConverter.getWeather(getCityData()).getNow().getCond().getTxt();
            RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.weather_appwidget);
            remoteView.setTextViewText(R.id.widget_city,cityName);
            remoteView.setTextViewText(R.id.widget_temperature,temp+"℃");
            remoteView.setImageViewResource(R.id.widget_weather_img, WeatherIcon.getWeatherImage(WeatherJsonConverter.getWeather(getCityData()).getNow().getCond().getCode()));
            remoteView.setTextViewText(R.id.widget_weather_text,cond);
            // 更新 widget
            if (MyApplication.widget()) {
                appWidgetManager.updateAppWidget(appID, remoteView);
            }
        }
    }

