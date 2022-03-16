    public static void setSunrise(Context context, RemoteViews remoteViews, Calendar calendar, Locale locale,
                                  int widgetSunriseId, int widgetSunriseIconId, Set<Integer> enabledDetails) {
        if (!isDetailVisible(5, remoteViews, widgetSunriseId, widgetSunriseIconId, enabledDetails)) {
            return;
        }
        String value = "";
        if (calendar != null) {
            value = AppPreference.getLocalizedTime(context, calendar.getTime(), locale);
        }
        if (AppPreference.showLabelsOnWidget(context)) {
            String sunrise = context.getString(R.string.sunrise_label, value);
            remoteViews.setTextViewText(widgetSunriseId, sunrise);
            remoteViews.setViewVisibility(widgetSunriseIconId, TextView.GONE);
        } else {
            String sunrise = ": " + value;
            remoteViews.setImageViewBitmap(widgetSunriseIconId, Utils.createWeatherIcon(context, context.getString(R.string.icon_sunrise)));
            remoteViews.setViewVisibility(widgetSunriseIconId, TextView.VISIBLE);
            remoteViews.setTextViewText(widgetSunriseId, sunrise);
        }
    }

