    public static void setWind(Context context, RemoteViews remoteViews, float value, float direction, Locale locale,
                               int widgetWindId, int widgetWindIconId, Set<Integer> enabledDetails) {
        if (!isDetailVisible(0, remoteViews, widgetWindId, widgetWindIconId, enabledDetails)) {
            return;
        }
        WindWithUnit windWithUnit = AppPreference.getWindWithUnit(context, value, direction, locale);
        if (AppPreference.showLabelsOnWidget(context)) {
            String wind = context.getString(R.string.wind_label,
                            windWithUnit.getWindSpeed(0),
                            windWithUnit.getWindUnit(),
                            windWithUnit.getWindDirection());
            remoteViews.setTextViewText(widgetWindId, wind);
            remoteViews.setViewVisibility(widgetWindIconId, TextView.GONE);
        } else {
            String wind = ": " + windWithUnit.getWindSpeed(0) + " " + windWithUnit.getWindUnit();
            remoteViews.setImageViewBitmap(widgetWindIconId, Utils.createWeatherIcon(context, context.getString(R.string.icon_wind)));
            remoteViews.setViewVisibility(widgetWindIconId, TextView.VISIBLE);
            remoteViews.setTextViewText(widgetWindId, wind);
        }
    }

