    private static Integer getCityViewId(Class widgetClass) {
        if (ExtLocationWidgetProvider.class.equals(widgetClass)) {
            return R.id.widget_ext_loc_3x3_widget_city;
        } else if (MoreWidgetProvider.class.equals(widgetClass)) {
            return R.id.widget_more_3x3_widget_city;
        } else if (LessWidgetProvider.class.equals(widgetClass)) {
            return R.id.widget_less_3x1_widget_city;
        } else if (ExtLocationWithForecastWidgetProvider.class.equals(widgetClass)) {
            return R.id.widget_ext_loc_forecast_3x3_widget_city;
        } else if (ExtLocationWithGraphWidgetProvider.class.equals(widgetClass)) {
            return R.id.widget_ext_loc_graph_3x3_widget_city;
        } else if (ExtLocationWithForecastGraphWidgetProvider.class.equals(widgetClass)) {
            return R.id.widget_ext_loc_forecast_graph_3x3_widget_city;
        } else {
            return null;
        }
    }

