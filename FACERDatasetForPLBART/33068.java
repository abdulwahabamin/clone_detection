    public static void setWidgetTheme(Context context, RemoteViews remoteViews) {

        int textColorId = AppPreference.getTextColor(context);
        int backgroundColorId = AppPreference.getWidgetBackgroundColor(context);
        int windowHeaderBackgroundColorId = AppPreference.getWindowHeaderBackgroundColorId(context);
        
        remoteViews.setInt(R.id.widget_less_3x1_widget_root, "setBackgroundColor", backgroundColorId);
        remoteViews.setTextColor(R.id.widget_less_3x1_widget_temperature, textColorId);
        remoteViews.setTextColor(R.id.widget_less_3x1_widget_second_temperature, textColorId);
        remoteViews.setTextColor(R.id.widget_less_3x1_widget_description, textColorId);
        remoteViews.setInt(R.id.widget_less_3x1_header_layout, "setBackgroundColor", windowHeaderBackgroundColorId);
    }

