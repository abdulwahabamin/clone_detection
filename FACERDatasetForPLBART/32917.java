    public static void setClouds(Context context, RemoteViews remoteViews, int value,
                                 int widgetCloudsId, int widgetCloudsIconId, Set<Integer> enabledDetails) {
        if (!isDetailVisible(3, remoteViews, widgetCloudsId, widgetCloudsIconId, enabledDetails)) {
            return;
        }
        String percentSign = context.getString(R.string.percent_sign);
        if (AppPreference.showLabelsOnWidget(context)) {
            String cloudnes =
                    context.getString(R.string.cloudiness_label,
                            String.valueOf(value), percentSign);
            remoteViews.setTextViewText(widgetCloudsId, cloudnes);
            remoteViews.setViewVisibility(widgetCloudsIconId, TextView.GONE);
        } else {
            String cloudnes = ": " + String.valueOf(value) + " " + percentSign;
            remoteViews.setImageViewBitmap(widgetCloudsIconId, Utils.createWeatherIcon(context, context.getString(R.string.icon_cloudiness)));
            remoteViews.setViewVisibility(widgetCloudsIconId, TextView.VISIBLE);
            remoteViews.setTextViewText(widgetCloudsId, cloudnes);
        }
    }

