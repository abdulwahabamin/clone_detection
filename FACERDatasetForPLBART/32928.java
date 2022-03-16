    public static void updateWidgets(Context context) {
        updateWidgetForType(context, LessWidgetProvider.class);
        updateWidgetForType(context, MoreWidgetProvider.class);
        updateWidgetForType(context, ExtLocationWidgetProvider.class);
        updateWidgetForType(context, ExtLocationWithForecastWidgetProvider.class);
        updateWidgetForType(context, WeatherForecastWidgetProvider.class);
        updateWidgetForType(context, ExtLocationWithGraphWidgetProvider.class);
        updateWidgetForType(context, WeatherGraphWidgetProvider.class);
        updateWidgetForType(context, ExtLocationWithForecastGraphWidgetProvider.class);
    }

