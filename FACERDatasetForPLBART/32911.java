    public static void setSunset(Context context, RemoteViews remoteViews, Calendar calendar, Locale locale,
                                 int widgetSunsetId, int widgetSunsetIconId, Set<Integer> enabledDetails) {
        if (!isDetailVisible(6, remoteViews, widgetSunsetId, widgetSunsetIconId, enabledDetails)) {
            return;
        }
        String value = "";
        if (calendar != null) {
            value = AppPreference.getLocalizedTime(context, calendar.getTime(), locale);
        }
        if (AppPreference.showLabelsOnWidget(context)) {
            String sunset = context.getString(R.string.sunset_label, value);
            remoteViews.setTextViewText(widgetSunsetId, sunset);
            remoteViews.setViewVisibility(widgetSunsetIconId, TextView.GONE);
        } else {
            String sunset = ": " + value;
            remoteViews.setImageViewBitmap(widgetSunsetIconId, Utils.createWeatherIcon(context, context.getString(R.string.icon_sunset)));
            remoteViews.setViewVisibility(widgetSunsetIconId, TextView.VISIBLE);
            remoteViews.setTextViewText(widgetSunsetId, sunset);
        }
    }

