    public static void setPressure(Context context, RemoteViews remoteViews, float value, Locale locale,
                                   int widgetPressureId, int widgetPressureIconId, Set<Integer> enabledDetails) {
        if (!isDetailVisible(2, remoteViews, widgetPressureId, widgetPressureIconId, enabledDetails)) {
            return;
        }
        PressureWithUnit pressureWithUnit = AppPreference.getPressureWithUnit(context, value, locale);
        if (AppPreference.showLabelsOnWidget(context)) {
            String pressure =
                    context.getString(R.string.pressure_label,
                            pressureWithUnit.getPressure(AppPreference.getPressureDecimalPlaces(context)),
                            pressureWithUnit.getPressureUnit());
            remoteViews.setTextViewText(widgetPressureId, pressure);
            remoteViews.setViewVisibility(widgetPressureIconId, TextView.GONE);
        } else {
            String pressure = ": " + pressureWithUnit.getPressure(0) + " " + pressureWithUnit.getPressureUnit();
            remoteViews.setImageViewBitmap(widgetPressureIconId, Utils.createWeatherIcon(context, context.getString(R.string.icon_barometer)));
            remoteViews.setViewVisibility(widgetPressureIconId, TextView.VISIBLE);
            remoteViews.setTextViewText(widgetPressureId, pressure);
        }
    }

