    public static void setHumidity(Context context, RemoteViews remoteViews, int value,
                                   int humidityId, int humidityIconId, Set<Integer> enabledDetails) {
        if (!isDetailVisible(1, remoteViews, humidityId, humidityIconId, enabledDetails)) {
            return;
        }
        String percentSign = context.getString(R.string.percent_sign);
        if (AppPreference.showLabelsOnWidget(context)) {
            String humidity =
                    context.getString(R.string.humidity_label,
                            String.valueOf(value), percentSign);
            remoteViews.setTextViewText(humidityId, humidity);
            remoteViews.setViewVisibility(humidityIconId, TextView.GONE);
        } else {
            String humidity = ": " + String.valueOf(value) + percentSign;
            remoteViews.setImageViewBitmap(humidityIconId, Utils.createWeatherIcon(context, context.getString(R.string.icon_humidity)));
            remoteViews.setViewVisibility(humidityIconId, TextView.VISIBLE);
            remoteViews.setTextViewText(humidityId, humidity);
        }
    }

