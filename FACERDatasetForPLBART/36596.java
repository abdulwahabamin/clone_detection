    private void updateViews() {

        rv = new RemoteViews(getPackageName(), R.layout.widget_1);
        cn = new ComponentName(getApplicationContext(), WidgetProvider.class);
        manager = AppWidgetManager.getInstance(getApplicationContext());

        // 为天气图标视图注册监�?�事件，打开简约天气
        Intent intent_1 = new Intent(this, WeatherActivity.class);
        PendingIntent pendingIntent_1 = PendingIntent.getActivity(this, 0, intent_1, 0);
        rv.setOnClickPendingIntent(R.id.widget1_weather_icon, pendingIntent_1);

        // 为时间视图注册监�?�事件，打开系统时钟
        Intent intent_2 = new Intent();
        intent_2.setComponent(componentName);
        PendingIntent pendingIntent_2 = PendingIntent.getActivity(this, 0, intent_2, 0);
        rv.setOnClickPendingIntent(R.id.widget1_time, pendingIntent_2);

        String str = sdf.format(new Date());
        // 当�?时间
        String time = str.substring(0, 7);
        // 当�?日期
        Lunar lunar = new Lunar(Calendar.getInstance());
        String date = str.substring(8) + "   |   " + lunar.toString().substring(5);

        SharedPreferences.Editor editor = getSharedPreferences("data_setting", MODE_PRIVATE).edit();
        editor.commit();
        SharedPreferences prefs = getSharedPreferences("data_setting", MODE_PRIVATE);

        rv.setTextViewText(R.id.widget1_time, time);
        rv.setTextViewText(R.id.widget1_date, date);
        if (prefs.getString("nonce_city", null) == null) {
            int weather_icon = R.mipmap.not_applicable;
            rv.setImageViewResource(R.id.widget1_weather_icon, weather_icon);
            rv.setTextViewText(R.id.widget1, "一个城市也木有~");
        } else {
            // 城市�??
            String city_name = prefs.getString("nonce_city", null);
            prefs = getSharedPreferences(city_name, MODE_PRIVATE);
            if (prefs.getString("type_0", null) == null) {
                int weather_icon = R.mipmap.not_applicable;
                rv.setImageViewResource(R.id.widget1_weather_icon, weather_icon);
                rv.setTextViewText(R.id.widget1, "一个城市也木有~");
            } else {
                // 天气类型
                String weather_type = prefs.getString("type_0", null);
                // 当�?温度
                String weather_wendu = prefs.getString("wendu", null);
                // 天气信�?�汇总
                String weather = city_name + " | " + weather_type + " " + weather_wendu + "°";
                // 天气图标
                int weather_icon = WeatherActivity.selectImage(weather_type);
                rv.setImageViewResource(R.id.widget1_weather_icon, weather_icon);
                rv.setTextViewText(R.id.widget1, weather);
            }

        }
        manager.updateAppWidget(cn, rv);
    }

