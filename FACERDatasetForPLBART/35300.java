    @Override
    public void onDisabled(Context context) {
        // 在最�?�一个 widget 被删除时，终止�?务
        context.stopService(new Intent(context,WeatherWidgetService.class));
        super.onDisabled(context);
    }

