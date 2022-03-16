    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        String action = intent.getAction();
        if (UPDATE_ACTION.equals(action)) {

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            updateWidget(context,appWidgetManager);
        }

    }

