    @Override
    public void onReceive(Context context, Intent intent) {

        // “更新�?广播
        updateAllAppWidgets(context, AppWidgetManager.getInstance(context), idsSet);

        super.onReceive(context, intent);
    }

