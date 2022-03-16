    private void rotateRefreshButtonOneStep() {
        AppWidgetManager widgetManager = AppWidgetManager.getInstance(this);
        for (ComponentName componentName: widgetTypes.keySet()) {
            RemoteViews rv = new RemoteViews(this.getPackageName(), widgetTypes.get(componentName));

            int[] widgetIds = widgetManager.getAppWidgetIds(componentName);
            for (int appWidgetId : widgetIds) {
                Integer currentRotationIndex = WidgetRefreshIconService.currentRotationIndexes.get(appWidgetId);
                if ((currentRotationIndex == null) || (currentRotationIndex >= refreshIcons.length)) {
                    currentRotationIndex = 0;
                }
                rv.setImageViewResource(R.id.widget_ext_loc_3x3_widget_button_refresh, refreshIcons[currentRotationIndex]);
                rv.setImageViewResource(R.id.widget_ext_loc_forecast_3x3_widget_button_refresh, refreshIcons[currentRotationIndex]);
                rv.setImageViewResource(R.id.widget_ext_loc_graph_3x3_widget_button_refresh, refreshIcons[currentRotationIndex]);
                rv.setImageViewResource(R.id.widget_less_3x1_widget_button_refresh, refreshIcons[currentRotationIndex]);
                rv.setImageViewResource(R.id.widget_more_3x3_widget_button_refresh, refreshIcons[currentRotationIndex]);
                rv.setImageViewResource(R.id.widget_ext_loc_forecast_graph_3x3_widget_button_refresh, refreshIcons[currentRotationIndex]);
                widgetManager.partiallyUpdateAppWidget(appWidgetId, rv);
                WidgetRefreshIconService.currentRotationIndexes.put(appWidgetId, ++currentRotationIndex);
            }
        }
    }

