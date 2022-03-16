    @Override
    public void onReceive(Context context, Intent intent) {
        appendLog(context, TAG, "intent:", intent, ", widget:", getWidgetClass());
        Bundle extras = intent.getExtras();
        if (extras != null) {
            int appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID);
            appendLog(context, TAG, "EXTRA_APPWIDGET_ID:" + appWidgetId);
        }

        super.onReceive(context, intent);
        AppWidgetManager widgetManager = AppWidgetManager.getInstance(context);

        Integer widgetId = null;
        ComponentName widgetComponent = new ComponentName(context, getWidgetClass());

        if (intent.hasExtra("widgetId")) {
            widgetId = intent.getIntExtra("widgetId", 0);
            if (widgetId == 0) {
                widgetId = null;
            }
        }
        if (widgetId == null) {
            int[] widgetIds = widgetManager.getAppWidgetIds(widgetComponent);
            if (widgetIds.length == 0) {
                return;
            }
            for (int widgetIditer: widgetIds) {
                performActionOnReceiveForWidget(context, intent, widgetIditer);
            }
            return;
        }
        performActionOnReceiveForWidget(context, intent, widgetId);
    }

