    @Override
    protected void handleAdditionalActions(Intent intent) {
        if (APPWIDGETUPDATE_ACTION.equals(intent.getAction())) {
            // Someone asked us to refresh a set of specific widgets, probably
            // because they were just added.
            int[] appWidgetIds = intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);
            MediaAppWidgetProvider.getInstance().performUpdate(MobileMediaPlaybackService.this, appWidgetIds);
        }
    }

