    private WidgetDefaultDetailsResult getNumberOfCurrentWeatherDetails(int widgetId) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        ComponentName widgetComponent = new ComponentName(this, ExtLocationWithForecastGraphWidgetProvider.class);
        int[] widgetIds = appWidgetManager.getAppWidgetIds(widgetComponent);
        for (int currentWidgetId: widgetIds) {
            if (currentWidgetId == widgetId) {
                return new WidgetDefaultDetailsResult(
                        ExtLocationWithForecastGraphWidgetProvider.getNumberOfCurrentWeatherDetails(),
                        ExtLocationWithForecastGraphWidgetProvider.getDefaultCurrentWeatherDetails());
            }
        }
        widgetComponent = new ComponentName(this, ExtLocationWidgetProvider.class);
        widgetIds = appWidgetManager.getAppWidgetIds(widgetComponent);
        for (int currentWidgetId: widgetIds) {
            if (currentWidgetId == widgetId) {
                return new WidgetDefaultDetailsResult(
                        ExtLocationWidgetProvider.getNumberOfCurrentWeatherDetails(),
                        ExtLocationWidgetProvider.getDefaultCurrentWeatherDetails());
            }
        }
        widgetComponent = new ComponentName(this, ExtLocationWithForecastWidgetProvider.class);
        widgetIds = appWidgetManager.getAppWidgetIds(widgetComponent);
        for (int currentWidgetId: widgetIds) {
            if (currentWidgetId == widgetId) {
                return new WidgetDefaultDetailsResult(
                        ExtLocationWithForecastWidgetProvider.getNumberOfCurrentWeatherDetails(),
                        ExtLocationWithForecastWidgetProvider.getDefaultCurrentWeatherDetails());
            }
        }
        widgetComponent = new ComponentName(this, ExtLocationWithGraphWidgetProvider.class);
        widgetIds = appWidgetManager.getAppWidgetIds(widgetComponent);
        for (int currentWidgetId: widgetIds) {
            if (currentWidgetId == widgetId) {
                return new WidgetDefaultDetailsResult(
                        ExtLocationWithGraphWidgetProvider.getNumberOfCurrentWeatherDetails(),
                        ExtLocationWithGraphWidgetProvider.getDefaultCurrentWeatherDetails());
            }
        }
        widgetComponent = new ComponentName(this, MoreWidgetProvider.class);
        widgetIds = appWidgetManager.getAppWidgetIds(widgetComponent);
        for (int currentWidgetId: widgetIds) {
            if (currentWidgetId == widgetId) {
                return new WidgetDefaultDetailsResult(
                        MoreWidgetProvider.getNumberOfCurrentWeatherDetails(),
                        MoreWidgetProvider.getDefaultCurrentWeatherDetails());
            }
        }
        return new WidgetDefaultDetailsResult(
                DEFAULT_NUMBER_OF_AVAILABLE_DETAIL_OPTIONS_IN_WIDGET,
                "0,1,2,3");
    }

