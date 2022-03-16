    @Override
    public void onCreate() {
        super.onCreate();
        widgetTypes.put(new ComponentName(this, ExtLocationWidgetProvider.class), R.layout.widget_ext_loc_3x3);
        widgetTypes.put(new ComponentName(this, MoreWidgetProvider.class), R.layout.widget_more_3x3);
        widgetTypes.put(new ComponentName(this, LessWidgetProvider.class), R.layout.widget_less_3x1);
        widgetTypes.put(new ComponentName(this, ExtLocationWithForecastWidgetProvider.class), R.layout.widget_less_3x1);
        widgetTypes.put(new ComponentName(this, ExtLocationWithForecastGraphWidgetProvider.class), R.layout.widget_ext_loc_forecast_graph_3x3);
        //widgetTypes.put(new ComponentName(this, WeatherForecastWidgetProvider.class), R.layout.widget_less_3x1);
        powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        IntentFilter filterScreenOn = new IntentFilter(Intent.ACTION_SCREEN_ON);
        getApplication().registerReceiver(screenOnReceiver, filterScreenOn);
    }

