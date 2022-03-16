    public static void setWidgetTheme(Context context, RemoteViews remoteViews) {
        appendLog(context, TAG, "setWidgetTheme:start");
        int textColorId = AppPreference.getTextColor(context);
        int backgroundColorId = AppPreference.getWidgetBackgroundColor(context);
        int windowHeaderBackgroundColorId = AppPreference.getWindowHeaderBackgroundColorId(context);

        remoteViews.setInt(R.id.widget_ext_loc_3x3_widget_root, "setBackgroundColor", backgroundColorId);
        remoteViews.setTextColor(R.id.widget_ext_loc_3x3_widget_temperature, textColorId);
        remoteViews.setTextColor(R.id.widget_ext_loc_3x3_widget_description, textColorId);
        remoteViews.setTextColor(R.id.widget_ext_loc_3x3_widget_description, textColorId);
        remoteViews.setTextColor(R.id.widget_ext_loc_3x3_widget_second_temperature, textColorId);
        remoteViews.setInt(R.id.widget_ext_loc_3x3_header_layout, "setBackgroundColor", windowHeaderBackgroundColorId);
        appendLog(context, TAG, "setWidgetTheme:end");
    }

