    public static void setDewPoint(Context context, RemoteViews remoteViews, Weather weather,
                                   Locale locale, int dewPointId, int dewPointIconId,
                                   Set<Integer> enabledDetails) {
        if (!isDetailVisible(4, remoteViews, dewPointId, dewPointIconId, enabledDetails)) {
            return;
        }
        String value = "";
        if (weather != null) {
            value = TemperatureUtil.getDewPointWithUnit(context, weather, locale);
        }
        if (AppPreference.showLabelsOnWidget(context)) {
            String dewPointValue = context.getString(
                    R.string.dew_point_label,
                    value);
            remoteViews.setTextViewText(dewPointId, dewPointValue);
            remoteViews.setViewVisibility(dewPointIconId, TextView.GONE);
        } else {
            String dewPointValue = ": " + value;
            remoteViews.setImageViewBitmap(dewPointIconId, Utils.createWeatherIcon(context, context.getString(R.string.icon_dew_point)));
            remoteViews.setViewVisibility(dewPointIconId, TextView.VISIBLE);
            remoteViews.setTextViewText(dewPointId, dewPointValue);
        }
    }

